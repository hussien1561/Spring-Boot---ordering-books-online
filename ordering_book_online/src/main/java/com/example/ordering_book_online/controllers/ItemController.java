package com.example.ordering_book_online.controllers;

import com.example.ordering_book_online.DTO.ItemDTO;
import com.example.ordering_book_online.DTO.ItemRequestDTO;
import com.example.ordering_book_online.DTO.StockItemDTO;
import com.example.ordering_book_online.mapper.ItemMapper;
import com.example.ordering_book_online.mapper.StockMapper;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.repo.ItemRepo;
import com.example.ordering_book_online.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ItemController {
    
    ItemService itemService;
    ItemRepo itemRepo ;

    public ItemController(ItemService itemService , ItemRepo itemRepo    ) {
        this.itemService = itemService;
        this.itemRepo = itemRepo ;
    }

    // controller method for    create item

    @PostMapping("orderingBook/api/item")
    public ResponseEntity<Item> createItem (@RequestBody ItemRequestDTO dto ){

        // accept new   item     in request  body   as        item  request dto   (  dto  )   
        // create new item in db          using  service method
        //  return   item    as    response 
        
        Item savedItem   = itemService.createItem( dto );

        return ResponseEntity.ok( savedItem ) ;
        
        

    }


    @GetMapping("orderingBook/api/item")
        public ResponseEntity<List<ItemDTO>>   getItems (){

        List<Item> items =   itemRepo.findAll();

        return ResponseEntity.ok(ItemMapper.toItemDTO( items ));


    }

    @GetMapping("orderingBook/api/stock")
        public ResponseEntity<List<StockItemDTO>> getStock (){

        List<Item> stockItems = itemRepo.findByOrderByStockAsc();

        return ResponseEntity.ok( StockMapper.toStockDTO( stockItems  )) ;

    }


}
