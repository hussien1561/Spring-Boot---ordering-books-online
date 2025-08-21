package com.example.ordering_book_online.service;

import com.example.ordering_book_online.DTO.DiscountRuleDTO;
import com.example.ordering_book_online.model.DiscountRule;
import com.example.ordering_book_online.repo.DiscountRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {




    //private  Integer cartItemQuantity =   20 ;


    private  final  DiscountRuleRepository discountRuleRepository  ;

    public DiscountService(DiscountRuleRepository discountRuleRepository) {
        this.discountRuleRepository = discountRuleRepository;
    }


    public Optional<DiscountRule>  findApplicableDiscountRule (int  cartItemQuantity  ){

        List<DiscountRule> discountRules =   discountRuleRepository.findAllByOrderByMinQuantityDesc();
        return discountRules.stream().filter( r -> r.getMinQuantity() <= cartItemQuantity   ).findFirst()  ;


    }



    // method    // return List<String >         //     take  nothing

    public List<String> getDiscountRulesStatements (){


        List<String> discountRules   = discountRuleRepository.findAll().stream().map(

                discountRule -> "the id " + discountRule.getId()  +
                        " ,   there is  " + discountRule.getPercent()  +
                        "  discount for buying  " + discountRule.getMinQuantity() +  "  items or more "

        ).toList();
        return discountRules;

    }



    // method  return void   ,  takes  rule id , discount rule dto

    public void updateDiscountRule (Long ruleId , DiscountRuleDTO dto ){


        // grab that rule
        DiscountRule discountRule  =  discountRuleRepository.findById( ruleId).orElseThrow(
                () -> new RuntimeException("no discount rule with that id  ")
        );

        // update it

        discountRule.setPercent( dto.percent() );
        discountRule.setMinQuantity( dto.minQuantity() );
        discountRuleRepository.save(  discountRule  );


    }


}
