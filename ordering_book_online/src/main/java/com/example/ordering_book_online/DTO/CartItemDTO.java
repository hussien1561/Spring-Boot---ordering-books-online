package com.example.ordering_book_online.DTO;

public record CartItemDTO(

        Long itemId,
        String title,
        Integer quantity,
        double unitPrice,
        String discountNote

) {
}
