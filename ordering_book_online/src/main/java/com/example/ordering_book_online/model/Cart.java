package com.example.ordering_book_online.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    @Column(name = "cart_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // prevent infinite recursion   // This way, when you serialize a Cart, it won’t try to serialize its Customer again



    private String status ;

    private LocalDate releaseDate;




    @OneToMany( mappedBy = "cart"  ,  cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();


    //  helper to add item    to  the  list of cart items

    public  void addItem ( CartItem  item   ){
        cartItems.add( item );

        // associate item with cart list  cart
        item.setCart( this );


    }



    public Cart(){

    }

    public Cart(Customer customer, String status, LocalDate releaseDate, List<CartItem> cartItems) {
        this.customer = customer;
        this.status = status;
        this.releaseDate = releaseDate;
        this.cartItems = cartItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customer=" + customer +
                ", cartItems=" + cartItems +
                '}';
    }
}
