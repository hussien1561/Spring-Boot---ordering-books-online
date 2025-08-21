package com.example.ordering_book_online.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private long id;

    @Column
    private String title;

    @Column
    private double  price;

    @Column
    private String category;

    @Column
    private String length;

    private LocalDate releaseDate;

    private int stock;

    private int min_quantity_threshold;


    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RestockRequest> restockRequests ;


    public boolean isReleased (){

        if (  this.releaseDate == null    ){
            return true;
        }

        return !this.releaseDate.isAfter(LocalDate.now());


    };



    public Item(){
    }


    public Item(String title, double price, String category, String length, LocalDate releaseDate, int stock, int min_quantity_threshold) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.length = length;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.min_quantity_threshold = min_quantity_threshold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }



    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate  releaseDate) {
        this.releaseDate = releaseDate;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin_quantity_threshold() {
        return min_quantity_threshold;
    }

    public void setMin_quantity_threshold(int min_quantity_threshold) {
        this.min_quantity_threshold = min_quantity_threshold;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
