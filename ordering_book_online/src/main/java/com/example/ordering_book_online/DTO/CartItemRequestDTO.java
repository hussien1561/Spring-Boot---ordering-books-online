package com.example.ordering_book_online.DTO;

public record CartItemRequestDTO(

        long customer_id,
        int quantity



) {
    @Override
    public long customer_id() {
        return customer_id;
    }

    @Override
    public int quantity() {
        return quantity;
    }
}
