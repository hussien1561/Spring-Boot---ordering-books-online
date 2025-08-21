package com.example.ordering_book_online.service;

import com.example.ordering_book_online.model.Customer;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.model.Order;
import com.example.ordering_book_online.repo.CustomerRepo;
import com.example.ordering_book_online.repo.ItemRepo;
import com.example.ordering_book_online.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {


    CustomerRepo customerRepo;
    OrderRepo orderRepo;
    ItemRepo itemRepo ;

    public RecommendationService(CustomerRepo customerRepo ,  OrderRepo orderRepo ,  ItemRepo itemRepo   ) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
    }

    //   getRecommendedBooks  for   customer id


    @Transactional
    public List<Item>  getRecommendedItems ( Long customer_id   ){



        Customer customer =  customerRepo.findById( customer_id  )
                .orElseThrow( () -> new RuntimeException("customer not found")  ) ;


        // last order for the user

        Order order = orderRepo.findTopByCustomer_IdOrderByCreatedDateDesc( customer_id  ).
                orElseThrow( ()-> new RuntimeException(("no last order found")));


        // the category of an  item of  the last order

        String category =  order.getOrderItems().get(0).getItem().getCategory();



        // // 3. Find items in same category not ordered by this user

        List<Item> recommended  = itemRepo.findItemBYCategoryNotOrderedByUser(category , customer_id  );

        // get 3 of recommended items

        return recommended.stream().limit(3L ).toList();



    }


}
