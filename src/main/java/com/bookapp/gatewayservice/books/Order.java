package com.bookapp.gatewayservice.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private String bookIsbn;
    private Integer quantity;
    private String userEmail;

    public Order(String bookIsbn, Integer quantity, String userEmail) {
        this.bookIsbn = bookIsbn;
        this.quantity = quantity;
        this.userEmail = userEmail;
    }
}
