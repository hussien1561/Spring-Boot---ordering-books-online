package com.example.ordering_book_online.service; ;
import com.example.ordering_book_online.model.*;
import com.example.ordering_book_online.repo.CartRepo;
import com.example.ordering_book_online.repo.ItemRepo;
import com.example.ordering_book_online.repo.OrderRepo;
import com.example.ordering_book_online.repo.RestockRequestRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    CartRepo cartRepo;
    OrderRepo orderRepo ;
    ItemRepo itemRepo;
    RestockRequestRepo restockRequestRepo;

    public OrderService(CartRepo cartRepo  ,  OrderRepo orderRepo , ItemRepo itemRepo  ,  RestockRequestRepo restockRequestRepo  ) {

        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo ;
        this.restockRequestRepo = restockRequestRepo ;

    }


    @Transactional
    public Order   placeOrder (Long cart_id  ){

        Order order = new Order();

        List<OrderItem> orderItems = new ArrayList<>();

        Cart cart = cartRepo.findById(cart_id).orElseThrow( () -> new RuntimeException("cart not found")   );

        if ( cart.getCartItems().isEmpty()   ){
            throw new RuntimeException("cart is empty");
        }



        // convert   cart items   to  order items

        cart.getCartItems().forEach(   cartItem -> {

            OrderItem orderItem = new OrderItem();

            orderItem.setItemTitle( cartItem.getItem().getTitle()   );
            orderItem.setItem( cartItem.getItem()  );
            orderItem.setQuantity( cartItem.getQuantity() );

            orderItem.setPrice( cartItem.getUnitPrice() );
            orderItem.setDiscountNote(  cartItem.getDiscountNote()   );


            orderItem.setCustomer( cart.getCustomer() );



            if (  orderItem.getItem().isReleased()   ){

                orderItem.setReleaseDate( null );
                orderItem.setStatus("pending");
            }else {

                orderItem.setStatus("pre-order");
                orderItem.setReleaseDate( orderItem.getItem().getReleaseDate()  );
            }


            // decrease item   stock
            if (  orderItem.getItem().isReleased()   ) {

                Item item = orderItem.getItem();
                int updatedStock = item.getStock() - orderItem.getQuantity();

                if (updatedStock < 0) {
                    throw new RuntimeException("not enough Stock ");
                }


                // save  the stock to the item
                //cartItem.getItem().setStock( // cart item get item get stock - cart item quantity    );
                item.setStock( updatedStock );
                itemRepo.save( item  );


                // item
                // check and create re-stock  request
                checkAndCreateRestockRequest( item );


            }

            // add order item   to the   order
            order.addItem( orderItem );
        });


        // set total amount for the order
        double totalAmount =    cart.getCartItems().stream().mapToDouble(
                i -> i.getUnitPrice() * i.getQuantity() ).sum();

        order.setTotalAmount( totalAmount );

        // set the date and   for the order
        order.setCreatedDate(  LocalDateTime.now()  );

        order.setUser(  cart.getCustomer() );


        // clear the cart
        cart.getCartItems().clear();
        cartRepo.save(  cart  );




        // save the order the database
        // return the saved order
        return orderRepo.save(order  );


    }

    public  void checkAndCreateRestockRequest ( Item item){

        if ( item.getStock() < item.getMin_quantity_threshold()    ){

            // restock request  // item // date // request quantity 20 auto // stock // status

            RestockRequest restockRequest = new RestockRequest();

            restockRequest.setItem( item );
            restockRequest.setRequestDate(LocalDate.now() );
            restockRequest.setRequested_quantity(20);
            restockRequest.setCurrentStock( item.getStock()  );
            restockRequest.setRequestStatus( "pending");

            restockRequestRepo.save( restockRequest  );


        }


    }

}
