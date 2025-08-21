package com.example.ordering_book_online.DTO;

import java.util.List;

public record CartDTO(

        long cartId,
        List<CartItemDTO> cartItemDTOList

) {

}
