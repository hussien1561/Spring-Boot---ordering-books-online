package com.example.ordering_book_online.repo;


import com.example.ordering_book_online.model.Order;
import com.example.ordering_book_online.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepo  extends JpaRepository<OrderItem , Long > {


    Optional<List<OrderItem>> findByStatus (String status  );

}
