package com.example.ordering_book_online.DTO;

import java.time.LocalDate;

public record StockItemDTO(
        /*

        view stock
        stock items

        items stock


        id    title    , category     stock    release date       min quantity

        ordered by stock  asc

        refill request

        id    title    , category     stock    release date       min quantity
         */

        long id,
        String title ,
        String category ,
        Integer stock ,
        LocalDate releaseDate ,
        Integer minQuantity


) {
}
