package com.example.ordering_book_online.service;

import com.example.ordering_book_online.model.Cart;
import com.example.ordering_book_online.repo.CartRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    CartRepo cartRepo;


    public CustomerService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    // method to find customer by customer id
    //                cart by customer id


    @Transactional
    public Cart getCartOfCustomer ( Long customer_id ){



        //Cart cart = cartRepo.findAll(  ).orElse



        return cartRepo.findByCustomer_Id( customer_id   );

    }
}
