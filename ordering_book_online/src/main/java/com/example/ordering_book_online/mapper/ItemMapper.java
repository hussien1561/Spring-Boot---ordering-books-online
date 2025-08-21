package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.ItemDTO;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.service.ItemService;

import java.util.List;

public class ItemMapper {

    public static  List<ItemDTO>  toItemDTO (List<Item> items ){


        // id , title ,   price  category   ,  length   // release date

        List<ItemDTO> itemDTOS = items.stream().map(
                item -> new ItemDTO(
                        item.getId() ,
                        item.getTitle() ,
                        item.getPrice() ,
                        item.getCategory() ,
                        item.getLength() ,
                        item.getReleaseDate()
                )).toList();



        return itemDTOS;


    }

}
