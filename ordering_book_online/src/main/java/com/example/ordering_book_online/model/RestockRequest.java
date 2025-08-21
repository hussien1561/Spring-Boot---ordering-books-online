package com.example.ordering_book_online.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RestockRequest {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    @Column(name = "request_id")
    private long id;

    //
    //
    // book_id  ,  current_stock  ,  requested quantity  , status    , created date



    private int currentStock;

    private int requested_quantity;

    private String RequestStatus;

    private LocalDate RequestDate ;


    // request

    @ManyToOne()
    @JoinColumn(name = "item_id"  )
    @JsonBackReference
    private Item item;


    public RestockRequest  () {

    }

    public RestockRequest(int currentStock, int requested_quantity, String requestStatus, LocalDate requestDate, Item item) {
        this.currentStock = currentStock;
        this.requested_quantity = requested_quantity;
        this.RequestStatus = requestStatus;
        this.RequestDate = requestDate;
        this.item = item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getRequested_quantity() {
        return requested_quantity;
    }

    public void setRequested_quantity(int requested_quantity) {
        this.requested_quantity = requested_quantity;
    }

    public String getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        RequestStatus = requestStatus;
    }

    public LocalDate getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        RequestDate = requestDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
