package com.example.ordering_book_online.service;
import com.example.ordering_book_online.DTO.CartItemRequestDTO;
import com.example.ordering_book_online.model.Cart;
import com.example.ordering_book_online.model.CartItem;
import com.example.ordering_book_online.model.Customer;
import com.example.ordering_book_online.model.Item;
import com.example.ordering_book_online.repo.CartItemRepo;
import com.example.ordering_book_online.repo.CartRepo;
import com.example.ordering_book_online.repo.CustomerRepo;
import com.example.ordering_book_online.repo.ItemRepo;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    // method to add  item to cart


    // logic
    // method  accept  item  id


    // output
    //  cart    has a new cart item   ( item id  , quantity //  1  )


    // return      method       accept

    ItemRepo itemRepo ;
    CartRepo cartRepo;
    CartItemRepo cartItemRepo;
    CustomerRepo customerRepo;

    DiscountService discountService;

    public CartService(ItemRepo itemRepo, CartRepo cartRepo, CartItemRepo cartItemRepo, CustomerRepo customerRepo ,  DiscountService discountService  ) {
        this.itemRepo = itemRepo;
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
        this.customerRepo = customerRepo;

        this.discountService = discountService;
    }















    public void  addItemToCart (Long item_id , CartItemRequestDTO  dto  ){




        // get customer


        Customer customer = customerRepo.findById(dto.customer_id())    //dto.getCustomer_id() )
                .orElseThrow( () -> new RuntimeException("customer Not found"))  ;

        //  get Item

        Item item = itemRepo.findById( item_id ).orElseThrow( () -> new RuntimeException("item not found")  );


        // get cart

        Cart cart = customer.getCart();





        // if cart null        //      cart a new cart
        // related to customer
        // make it accessible from   both sides

        if ( cart == null   ){

            cart  = new Cart();
            customer.setCart( cart  );
            cart.setCustomer( customer );

        }

        // create the   intended cart item

        CartItem cartItem = new CartItem();

        cartItem.setItem( item );
        cartItem.setQuantity( dto.quantity() );    // dto.getQuantity()   );
        cartItem.setUnitPrice( item.getPrice() );


        if (  cartItem.getItem().isReleased()   ){


            cartItem.setReleaseDate(null);
            cartItem.setStatus("available");
        }else {

            cartItem.setStatus("pre-order");
            cartItem.setReleaseDate( cartItem.getItem().getReleaseDate().minusMonths(2L)  );
        }




        // set it  to   the cart

        cart.addItem( cartItem );











        // get cart    item quantity

        //Integer cart_item_quantity   =  dto.getQuantity();

        int cart_item_quantity    = dto.quantity()  ;

        discountService.findApplicableDiscountRule( cart_item_quantity ).ifPresent(

                rule -> {
                    double discountedPrice = item.getPrice() * (1 - ( (double) rule.getPercent() / 100 ) )  ;

                    cartItem.setUnitPrice( discountedPrice   );

                    cartItem.setDiscountNote( " there is" + rule.getPercent()  +   " %  discount for buying " + rule.getMinQuantity()  +  " items or more " );

                }

        );





        cartRepo.save( cart );


        System.out.println( cartRepo.findAll().isEmpty()  );
        //System.out.println( cartRepo.findAll().f  );



    }



}
