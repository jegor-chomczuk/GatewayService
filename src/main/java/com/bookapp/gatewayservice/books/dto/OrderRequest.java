package com.bookapp.gatewayservice.books.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderRequest {

    private String bookIsbn;

    private Integer quantity;

    private String userEmail;
}
