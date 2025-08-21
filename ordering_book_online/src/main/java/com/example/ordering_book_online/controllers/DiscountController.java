package com.example.ordering_book_online.controllers;
import com.example.ordering_book_online.DTO.DiscountRuleDTO;
import com.example.ordering_book_online.model.DiscountRule;
import com.example.ordering_book_online.repo.DiscountRuleRepository;
import com.example.ordering_book_online.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    DiscountRuleRepository  discountRuleRepository;


    DiscountService discountService;

    public DiscountController(DiscountRuleRepository discountRuleRepository, DiscountService discountService) {
        this.discountRuleRepository = discountRuleRepository;
        this.discountService = discountService;
    }

    // view discount rules
    // why
    // stuff can  see discount rules
    // list of string
    // make it simple

    @GetMapping("orderingBook/api/discountRules")
    public ResponseEntity<List<String>> getDiscountRules (){

        return ResponseEntity.ok(  discountService.getDiscountRulesStatements()  );

    }


    // why
    // stuff    edit discount rules
    // edit min quantity
    // edit percent

    @PutMapping("orderingBook/api/discountRules/{ruleId}")
    public ResponseEntity<String> updateDiscountRule  (@PathVariable("ruleId") Long ruleId , @RequestBody DiscountRuleDTO dto ){


        discountService.updateDiscountRule( ruleId , dto );

        return ResponseEntity.ok("the discount rule updated successfully ");

    }





}
