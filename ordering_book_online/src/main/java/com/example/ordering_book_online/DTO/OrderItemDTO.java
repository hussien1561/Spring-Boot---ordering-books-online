package com.example.ordering_book_online.DTO;

public record OrderItemDTO(

        // order item
        // item title   , quantity   , price , discount note  , status

        String title,
        Integer quantity ,
        double price ,
        String discountNote ,
        String status


) {
}
