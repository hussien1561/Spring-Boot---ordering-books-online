package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.CartItemDTO;
import com.example.ordering_book_online.DTO.OrderDTO;
import com.example.ordering_book_online.DTO.OrderItemDTO;
import com.example.ordering_book_online.model.Order;

import java.util.List;

public class OrderMapper {


    //        // item title   , quantity   , price , discount note  , status





    public static OrderDTO  toOrderDTO ( Order order   ){

        List<OrderItemDTO> orderItemDTOList = order.getOrderItems().stream().map(

                orderItem ->  new OrderItemDTO(
                        orderItem.getItem().getTitle() ,
                        orderItem.getQuantity() ,
                        orderItem.getPrice() ,
                        orderItem.getDiscountNote() ,
                        orderItem.getStatus()

                        )).toList() ;


        return  new OrderDTO(  orderItemDTOList,  order.getUser().getName()   ,
                order.getTotalAmount() , order.getCreatedDate()   );

    }


    //   order as a response
    //   total amount
    //   created date




}
