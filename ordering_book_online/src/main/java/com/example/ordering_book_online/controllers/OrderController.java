package com.example.ordering_book_online.controllers;

import com.example.ordering_book_online.DTO.OrderDTO;
import com.example.ordering_book_online.DTO.OrderItemDTO;
import com.example.ordering_book_online.mapper.OrderItemMapper;
import com.example.ordering_book_online.mapper.OrderMapper;
import com.example.ordering_book_online.model.Order;
import com.example.ordering_book_online.model.OrderItem;
import com.example.ordering_book_online.repo.OrderItemRepo;
import com.example.ordering_book_online.repo.OrderRepo;
import com.example.ordering_book_online.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;

@RestController
public class OrderController {

    OrderRepo orderRepo ;

    OrderItemRepo orderItemRepo;

    OrderService orderService  ;




    public OrderController(OrderRepo orderRepo, OrderItemRepo orderItemRepo, OrderService orderService) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.orderService = orderService;
    }

    @PostMapping("/orderingBook/api/order/place/{cart_id}")
    public ResponseEntity<OrderDTO>  placeOrder (@PathVariable("cart_id") Long cart_id   ){

        Order savedOrder = orderService.placeOrder( cart_id );

        return ResponseEntity.ok(  OrderMapper.toOrderDTO( savedOrder  )  );

    }


    // wht this feature

    // view pre  orders  items  so stuff can see them
    // get pre orders

    // is find by order items  status    works fine

    // simple

    @GetMapping("/orderingBook/api/order/pre-orders")
    public ResponseEntity<List<OrderItemDTO>> getPreOrders (){


        List<OrderItem> orderItems  = orderItemRepo.findByStatus("pre-order").orElseThrow(
                () -> new RuntimeException(" no pre order items   ")

        );

        return  ResponseEntity.ok( OrderItemMapper.toOrderItemsDTO( orderItems  )  );


    }






}
