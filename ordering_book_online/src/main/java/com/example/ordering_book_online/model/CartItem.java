package com.example.ordering_book_online.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class CartItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private long id;

    @Column
    private Integer quantity;


    @Column(name = "unit_price")
    private double UnitPrice;

    private String discountNote;


     @ManyToOne
     @JoinColumn(name="book_id"  )
     private  Item item;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


    private String status ;

    private LocalDate releaseDate;


    public CartItem(){


    }

    public CartItem(Integer quantity, double price, double unitPrice, String discountNote, Item item, Cart cart, String status, LocalDate releaseDate) {
        this.quantity = quantity;
        UnitPrice = unitPrice;
        this.discountNote = discountNote;
        this.item = item;
        this.cart = cart;
        this.status = status;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public  Item  getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", UnitPrice=" + UnitPrice +
                ", discountNote='" + discountNote + '\'' +
                ", item=" + item +
                ", cart=" + cart +
                '}';
    }
}
