package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.RestockRequestDTO;
import com.example.ordering_book_online.model.RestockRequest;

import java.util.List;

public class RestockRequestMapper {

    public static List<RestockRequestDTO>  toRestockRequestDTO ( List<RestockRequest> restockRequests  ) {

        List<RestockRequestDTO> restockRequestDTOS  = restockRequests.stream().map(

                restockRequest -> new RestockRequestDTO(


                        //
                        // restock request  // item id  // item title
                        // date // request quantity 20 auto // stock // status

                        restockRequest.getId() ,
                        restockRequest.getItem().getId() ,
                        restockRequest.getItem().getTitle(),
                        restockRequest.getRequestDate() ,
                        restockRequest.getRequested_quantity(),
                        restockRequest.getCurrentStock() ,
                        restockRequest.getRequestStatus()


                )

        ).toList();


        return restockRequestDTOS ;
    }




}
