package com.example.ordering_book_online.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private long id;

    @Column(name = "item_title")
    private String itemTitle;

    private Integer quantity;

    private double price;

    private String discountNote ;

    private String status ;

    private LocalDate  releaseDate;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    // no need to know  each order item  separately    that  belong to   customer

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference
    private Item item;

    // no need to know  each order item    that the  item belong to  separately

    // part of order
    // related to order
    // many to one

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public OrderItem(){

    }


    public OrderItem(String itemTitle, Integer quantity, double price, String discountNote, String status, LocalDate releaseDate, Customer customer, Item item, Order order) {
        this.itemTitle = itemTitle;
        this.quantity = quantity;
        this.price = price;
        this.discountNote = discountNote;
        this.status = status;
        this.releaseDate = releaseDate;
        this.customer = customer;
        this.item = item;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDiscountNote() {
        return discountNote;
    }

    public void setDiscountNote(String discountNote) {
        this.discountNote = discountNote;
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

    public void setReleaseDate(LocalDate  releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", itemTitle='" + itemTitle + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
