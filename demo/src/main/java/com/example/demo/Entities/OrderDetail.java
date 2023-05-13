package com.example.demo.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "orderDetail")
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    Order orderId;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    Product productId;

    @Column
    int numberOfUnit;

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getNumberOfUnit() {
        return numberOfUnit;
    }

    public void setNumberOfUnit(int numberOfUnit) {
        this.numberOfUnit = numberOfUnit;
    }

    public OrderDetail(Order orderId, Product productId, int numberOfUnit) {
        this.orderId = orderId;
        this.productId = productId;
        this.numberOfUnit = numberOfUnit;
    }

    public OrderDetail() {
    }
}
