package com.example.ordering_book_online.controllers;

import com.example.ordering_book_online.DTO.RestockRequestDTO;
import com.example.ordering_book_online.DTO.StockDTO;
import com.example.ordering_book_online.mapper.RestockRequestMapper;
import com.example.ordering_book_online.model.RestockRequest;
import com.example.ordering_book_online.repo.RestockRequestRepo;
import com.example.ordering_book_online.service.RestockRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestockController {


    RestockRequestService restockRequestService ;
    RestockRequestRepo restockRequestRepo;


    public RestockController(RestockRequestService restockRequestService, RestockRequestRepo restockRequestRepo) {
        this.restockRequestService = restockRequestService;
        this.restockRequestRepo = restockRequestRepo;
    }

    @GetMapping("/orderingBook/api/restock-request")
    public ResponseEntity<List<RestockRequestDTO>>  getRestockRequest () {

        List<RestockRequest> requestList = restockRequestRepo.findAll();

        return ResponseEntity.ok(RestockRequestMapper.toRestockRequestDTO( requestList ));

    }


    @PutMapping("/orderingBook/api/restock-request/{restock-requestId}")
    public ResponseEntity<String> updateRestockRequest (@PathVariable("restock-requestId") Long restockId  ,
                                      @RequestBody StockDTO stockDTO ){

        restockRequestService.updateRestockRequest(  restockId , stockDTO   );

        return ResponseEntity.ok( "restock request updated successfully ");


    }

}
