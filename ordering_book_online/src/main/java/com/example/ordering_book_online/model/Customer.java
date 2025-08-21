package com.example.ordering_book_online.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber ;

    // customer


    // related to cart

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL )
    @JsonManagedReference
    private Cart cart;


    //  related to  list of  order

    // one to many
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Order> orders;


    // customer

    //

    @ManyToMany(  cascade = CascadeType.MERGE )
    @JoinTable(
            name = "customer_recommended_item" ,
            joinColumns = @JoinColumn( name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "recommended_item_id")
    )
    @JsonBackReference
    private List<Item> recommendedItem;


    public Customer(){
    }


    public Customer(String name, String email, String phoneNumber, Cart cart, List<Order> orders ,  List<Item> recommendedItem    ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cart = cart;
        this.orders = orders;

        this.recommendedItem = recommendedItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    public List<Item> getRecommendedItem() {
        return recommendedItem;
    }

    public void setRecommendedItem(List<Item> recommendedItem) {
        this.recommendedItem = recommendedItem;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders=" + orders +
                '}';
    }


}
