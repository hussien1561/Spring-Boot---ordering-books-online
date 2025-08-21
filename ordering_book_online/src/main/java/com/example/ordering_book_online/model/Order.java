package com.example.ordering_book_online.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book_order")
public class Order  {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private long id;

    private double totalAmount;

    private LocalDateTime  createdDate;

    private String status ;   // placed or cancelled

    // related to user

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer  customer;

    // related to  order item

    // the field name in   related entity

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<OrderItem> orderItems = new ArrayList<>();


    public void  addItem ( OrderItem  orderItem  ){
        orderItems.add( orderItem );

        // order item // add to  it  // the current  order
        orderItem.setOrder( this );

    }


    public Order(){

    }

    public Order(double totalAmount,  LocalDateTime  createdDate  , Customer customer, List<OrderItem> orderItems) {
        this.totalAmount = totalAmount;
        this.createdDate = createdDate;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Customer getUser() {
        return customer;
    }

    public void setUser(Customer user) {
        this.customer = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
