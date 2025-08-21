package com.example.ordering_book_online.controllers;


import com.example.ordering_book_online.DTO.CartItemDTO;
import com.example.ordering_book_online.DTO.CartItemRequestDTO;
import com.example.ordering_book_online.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("orderingBook/api/cart/cart-items/{item_id}")
    public ResponseEntity<String> addItem (@RequestBody CartItemRequestDTO  dto  , @PathVariable("item_id") Long item_id) {

        // accept item id      as a pth variable
        // accept request body
        // use a  service method       to add item to the cart       user id , customer id , quantity


        cartService.addItemToCart( item_id , dto );

        return ResponseEntity.ok("Item added to cart successfully");


    }


}
