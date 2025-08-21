package com.example.ordering_book_online.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ItemDTO(

        // user
        // view item

        // id , title ,   price  category   ,  length   // release date   status  // pre order

        long id ,
        String title,
        double price ,
        String category ,
        String  length ,
        LocalDate  releaseDate



) {
}
