package com.example.ordering_book_online.repo;

import com.example.ordering_book_online.model.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiscountRuleRepository extends JpaRepository<DiscountRule , Long > {

    List<DiscountRule> findAllByOrderByMinQuantityDesc();






   // List<DiscountRule> findAllByOrderByMinQuantityDesc();

}
