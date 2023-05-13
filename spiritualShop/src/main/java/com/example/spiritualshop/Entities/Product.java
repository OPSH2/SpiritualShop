package com.example.spiritualshop.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    String id;

    @Column
    String name;
    @Column
    String category;
    @Column
    float price;
    @Column
    String unit;
    @Column
    int numberInStock;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public Product(String id, String name, String category, float price, String unit, int numberInStock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.unit = unit;
        this.numberInStock = numberInStock;
    }
}
