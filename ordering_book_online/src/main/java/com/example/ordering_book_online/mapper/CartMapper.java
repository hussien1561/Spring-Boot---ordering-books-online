package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.CartDTO;
import com.example.ordering_book_online.DTO.CartItemDTO;
import com.example.ordering_book_online.model.Cart;

import java.util.List;

public class CartMapper {

    public static CartDTO  toCartResponseDTo ( Cart cart    ){

        List<CartItemDTO> cartItemDTOS = cart.getCartItems().stream().map(

                cartItem -> new CartItemDTO(
                        cartItem.getItem().getId() ,
                        cartItem.getItem().getTitle(),
                        cartItem.getQuantity() ,
                        cartItem.getUnitPrice(),
                        cartItem.getDiscountNote()
                )).toList();


        return new CartDTO(  cart.getId() ,  cartItemDTOS ) ;


    }


}
