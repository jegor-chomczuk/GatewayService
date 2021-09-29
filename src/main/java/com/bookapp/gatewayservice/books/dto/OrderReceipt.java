package com.bookapp.gatewayservice.books.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReceipt {

    private String bookIsbn;

    private Integer quantity;

    private String userEmail;

    private Integer orderConfirmationCode;

    private String orderStatus;
}
