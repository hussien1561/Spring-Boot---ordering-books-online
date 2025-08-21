package com.example.ordering_book_online.repo;

import com.example.ordering_book_online.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartItemRepo extends JpaRepository<CartItem , Long > {
}
