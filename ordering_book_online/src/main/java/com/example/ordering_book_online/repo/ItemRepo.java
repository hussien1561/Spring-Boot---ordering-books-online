package com.example.ordering_book_online.repo;

import com.example.ordering_book_online.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item , Long> {


     @Query(""" 
             SELECT  i FROM Item i
             WHERE  i.category = :category
             AND i.id  NOT IN (
             SELECT oi.item.id  FROM
             OrderItem oi  JOIN  oi.order o
             WHERE o.customer.id = :customerId
             )
             """)
    List<Item> findItemBYCategoryNotOrderedByUser (@Param("category") String category ,
                                                   @Param("customerId") Long customer_id  );



     // find all items  order by stock  desc


    List<Item> findByOrderByStockAsc();
}
