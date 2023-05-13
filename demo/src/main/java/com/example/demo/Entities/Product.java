package com.example.demo.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    @Column
    String name;
    @Column
    float importPrice;
    @Column
    float sellingPrice;
    @Column
    int numberInStock;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetailList;


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

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public Product(String id, String name, float importPrice, float sellingPrice, int numberInStock) {
        this.id = id;
        this.name = name;
        this.importPrice = importPrice;
        this.sellingPrice = sellingPrice;
        this.numberInStock = numberInStock;
    }

    public Product() {
    }
}
