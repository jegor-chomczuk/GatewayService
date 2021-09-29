package com.bookapp.gatewayservice.books;

import com.bookapp.gatewayservice.books.dto.OrderReceipt;
import com.bookapp.gatewayservice.books.dto.OrderRequest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    public static final String TARGET_SERVICE = "order-service";
    private WebClient client;
    //    private final WebClient client = WebClient.create("http://localhost:8080");
    final DiscoveryClient discoveryClient;

    public OrdersController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        createClient();
    }

    private void createClient() {
        var serviceInstanceList = discoveryClient.getInstances(TARGET_SERVICE);
        String clientURI = serviceInstanceList.get(0).getUri().toString();
        client = WebClient.create(clientURI);
    }

    @GetMapping
    public List<Order> findAllOrders(){
        return client.get()
                .uri("/orders")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Order>>() {
                })
                .block();
    }

    @PostMapping
    public OrderReceipt orderReceiptGiver(@RequestBody OrderRequest orderRequest){
        return client.post()
                .uri("/orders")
                .body(Mono.just(orderRequest), OrderRequest.class)
                .retrieve()
                .bodyToMono(OrderReceipt.class)
                .block();
    }
}
