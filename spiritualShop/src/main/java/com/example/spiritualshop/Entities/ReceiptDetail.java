package com.example.spiritualshop.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class ReceiptDetail {
    @Id
    String receiptID;
    @Id
    String productId;

    @Column
    String customerID;

    @Column
    int numberofUnit;


    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getNumberofUnit() {
        return numberofUnit;
    }

    public void setNumberofUnit(int numberofUnit) {
        this.numberofUnit = numberofUnit;
    }

    public ReceiptDetail(String receiptID, String productId, String customerID, int numberofUnit) {
        this.receiptID = receiptID;
        this.productId = productId;
        this.customerID = customerID;
        this.numberofUnit = numberofUnit;
    }

    public ReceiptDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptDetail that = (ReceiptDetail) o;
        return receiptID.equals(that.receiptID) && productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptID, productId);
    }



}
