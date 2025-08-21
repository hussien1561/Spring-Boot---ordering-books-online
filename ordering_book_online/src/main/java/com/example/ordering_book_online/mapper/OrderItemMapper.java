package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.OrderItemDTO;
import com.example.ordering_book_online.model.OrderItem;

import java.util.List;

public class OrderItemMapper {

    public static List<OrderItemDTO>  toOrderItemsDTO (List<OrderItem>  orderItems  ){

        List<OrderItemDTO> orderItemDTOList = orderItems.stream().map(

                orderItem -> new OrderItemDTO(
                        orderItem.getItemTitle(),
                        orderItem.getQuantity(),
                        orderItem.getPrice() ,
                        orderItem.getDiscountNote(),
                        orderItem.getStatus()
                )

        ).toList();

        return orderItemDTOList;

    }
}
