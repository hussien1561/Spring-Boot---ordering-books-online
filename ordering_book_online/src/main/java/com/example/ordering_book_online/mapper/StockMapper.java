package com.example.ordering_book_online.mapper;

import com.example.ordering_book_online.DTO.StockItemDTO;
import com.example.ordering_book_online.model.Item;

import java.util.List;

public class StockMapper {

    public static  List<StockItemDTO> toStockDTO (List<Item> stockItems ) {

        // I  accept  list of items

        // I  want list of stock item dto

        List<StockItemDTO> stockItemDTOS = stockItems.stream().map(

                item ->  new StockItemDTO(
                        item.getId(),
                        item.getTitle(),
                        item.getCategory(),
                        item.getStock(),
                        item.getReleaseDate(),
                        item.getMin_quantity_threshold()

                )

        ).toList();


        return stockItemDTOS;

    }
}
