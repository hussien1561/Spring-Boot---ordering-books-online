package com.example.ordering_book_online.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(

        //   order as a response
        //   total amount
        //   created date

        // list of order item s
        //        // item title   , quantity   , price , discount note  , status


        //

        List<OrderItemDTO> orderItemDTOList ,
        String customerName ,
        double totalAmount  ,
        LocalDateTime createdDate


) {
}
