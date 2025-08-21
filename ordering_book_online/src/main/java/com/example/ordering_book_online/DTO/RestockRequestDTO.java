package com.example.ordering_book_online.DTO;

import java.time.LocalDate;

public record RestockRequestDTO(

        // restock request  // item id  // item title  // date // request quantity 20 auto // stock // status

        // we can edit   requested quantity   //  status

        long restockRequestId ,
        long itemId,
        String itemTitle,
        LocalDate createdDate ,
        Integer requestedQuantity,
        Integer stock ,
        String RestockStatus


) {
}
