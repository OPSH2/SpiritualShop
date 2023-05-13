package com.example.demo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    LocalDate estaDate;
    @ManyToOne
    @JoinColumn(name="staffId", nullable = false)
    Staff staff;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetailList;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getEstaDate() {
        return estaDate;
    }

    public void setEstaDate(LocalDate estaDate) {
        this.estaDate = estaDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(String id, LocalDate estaDate, Staff staff, List<OrderDetail> orderDetailList, Customer customer) {
        this.id = id;
        this.estaDate = estaDate;
        this.staff = staff;
        this.orderDetailList = orderDetailList;
        this.customer = customer;
    }

    public Order() {
    }
}
