package com.example.ordering_book_online.repo;

import com.example.ordering_book_online.model.Customer;
import com.example.ordering_book_online.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer , Long> {


    // method
    // property expression query
    //   return type       name         parameter
    //
    Optional<Customer> findByName (String name );

    //Optional<Order>  findByCustomer_Id


}
