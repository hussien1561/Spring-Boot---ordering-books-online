package com.example.ordering_book_online.service;


import com.example.ordering_book_online.DTO.StockDTO;
import com.example.ordering_book_online.model.RestockRequest;
import com.example.ordering_book_online.repo.RestockRequestRepo;
import org.springframework.stereotype.Service;

@Service
public class RestockRequestService {

    // update restock request
    // i get  request
    // i save  its data  to dto
    // i map dto data     to  the    restock request
    //   save it

    // get id of restock request
    // get request
    // get       restock request quantity     // status

    // update it

    RestockRequestRepo restockRequestRepo;


    public RestockRequestService(RestockRequestRepo restockRequestRepo) {
        this.restockRequestRepo = restockRequestRepo;
    }

    public void updateRestockRequest ( Long restockId  , StockDTO dto ){


        RestockRequest restockRequest =  restockRequestRepo.findById( restockId ).orElseThrow(
                () -> new RuntimeException("new restock request with that id ")
        );

        restockRequest.setRequested_quantity( dto.requestedQuantity()  );
       // restockRequest.setRequestStatus( dto.RestockStatus()  );

        restockRequest.setRequestStatus(dto.RestockStatus());

        System.out.println( dto.RestockStatus()  );

        System.out.println( restockRequest.getRequestStatus()   );

        restockRequestRepo.save( restockRequest );



    }





}
