package com.example.ordering_book_online.service;

import com.example.ordering_book_online.DTO.ItemRequestDTO;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.repo.ItemRepo;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    // accept item as dto
    //                                            service method to    save an item to db :
    //                                             save   dto  to db
    //     create class instance
    //      map dto   data   to   class instance
    //      save that class   to db
    //      return    that   item class instance


    //    return        method           accept
    //
    //    do

    ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item  createItem (ItemRequestDTO   dto    ){

        Item item = new Item();

        item.setTitle(dto.getTitle());
        item.setCategory(dto.getCategory());
        item.setLength(dto.getLength());
        item.setPrice( dto.getPrice() );

        return itemRepo.save( item);

    }







}
