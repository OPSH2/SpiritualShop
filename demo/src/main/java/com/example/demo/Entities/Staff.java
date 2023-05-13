package com.example.demo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    String name;

    @Column
    String telNum;

    @Column
    LocalDate onBoardDate;

    @Column
    LocalDate birthDate;

    @OneToMany(mappedBy = "staff")
    List<Order> orderList;

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

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public LocalDate getOnBoardDate() {
        return onBoardDate;
    }

    public void setOnBoardDate(LocalDate onBoardDate) {
        this.onBoardDate = onBoardDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Staff(String id, String name, String telNum, LocalDate onBoardDate, LocalDate birthDate, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.telNum = telNum;
        this.onBoardDate = onBoardDate;
        this.birthDate = birthDate;
        this.orderList = orderList;
    }

    public Staff() {
    }
}
