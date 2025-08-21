package com.example.ordering_book_online.DTO;

public class ItemRequestDTO {

    private  String title;

    private  double price;

    private  String category;

    private String length;


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



}
