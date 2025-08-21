package com.example.ordering_book_online.controllers;


import com.example.ordering_book_online.DTO.CartDTO;
import com.example.ordering_book_online.mapper.CartMapper;
import com.example.ordering_book_online.model.Cart;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.repo.CartRepo;
import com.example.ordering_book_online.service.CustomerService;
import com.example.ordering_book_online.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
     CustomerService customerService;


    CartRepo cartRepo ;




    RecommendationService recommendationService;

    public CustomerController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // get  request
    // i will accept customer id
    //
    // return cart

    @GetMapping("orderingBook/api/customer/{customer_id}/cart")
    public ResponseEntity<CartDTO> getCartItems (@PathVariable("customer_id") Long customer_id   ){

        // call method

        //Cart cart =  cartRepo.findByCustomer_Id( customer_id );


        Cart cart =  customerService.getCartOfCustomer(  customer_id );

        System.out.println( cart.getCartItems().isEmpty() );

        return ResponseEntity.ok(CartMapper.toCartResponseDTo( cart ));



    }


}
