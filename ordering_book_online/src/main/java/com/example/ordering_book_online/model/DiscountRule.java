package com.example.ordering_book_online.model;
import jakarta.persistence.*;

@Entity
public class DiscountRule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_quantity")
    private int minQuantity;

    // percent as integer (5 -> 5%)
    private int percent;

    public DiscountRule() {}

    public DiscountRule(int minQuantity, int percent) {
        this.minQuantity = minQuantity;
        this.percent = percent;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public int  getMinQuantity() { return minQuantity; }
    public void setMinQuantity(int minQuantity) { this.minQuantity = minQuantity; }


    public int getPercent() { return percent; }
    public void setPercent(int percent) { this.percent = percent; }


    @Override
    public String toString() {
        return "DiscountRule{" +
                "id=" + id +
                ", minQuantity=" + minQuantity +
                ", percent=" + percent +
                '}';
    }
}
