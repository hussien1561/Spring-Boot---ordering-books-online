package com.example.ordering_book_online.repo;

import com.example.ordering_book_online.model.Cart;
import com.example.ordering_book_online.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {


    // find cart by customer id
    Cart findByCustomer_Id (  Long  customer_id   );


}
