package com.example.ordering_book_online.controllers;

import com.example.ordering_book_online.DTO.ItemDTO;
import com.example.ordering_book_online.mapper.ItemMapper;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {


    RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // why   this    feature

    // can get personalized  recommendation for  each  diffrenet   customer based on last order

    // you can test it   with 3 customers


    // simple

    @GetMapping("orderingBook/api/recommendations/{customer_id}")
    public ResponseEntity<List< ItemDTO >> getRecommendedBooks (@PathVariable("customer_id") Long customer_id  ){

        List<Item> recommendations =  recommendationService.getRecommendedItems( customer_id  ) ;

        return ResponseEntity.ok(ItemMapper.toItemDTO( recommendations ));

    }





}
