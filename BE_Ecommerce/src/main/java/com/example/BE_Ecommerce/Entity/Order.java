package com.example.BE_Ecommerce.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @Column(name = "OrderUserID")
    private int orderUserId;

    @Column(name = "OrderAmount")
    private float orderAmount;

    @Column(name = "OrderShipName")
    private String orderShipName;

    @Column(name = "OrderShipAddress")
    private String orderShipAddress;

    @Column(name = "OrderShipAddress2")
    private String orderShipAddress2;

    @Column(name = "OrderCountry")
    private String orderCountry;

    @Column(name = "OrderPhone")
    private String orderPhone;

    @Column(name = "OrderShipping")
    private float orderShipping;

    @Column(name = "OrderEmail")
    private String orderEmail;

    @Column(name = "OrderDate")
    private Timestamp orderDate;

    @Column(name = "OrderShipped")
    private boolean orderShipped;

    @Column(name = "OrderTrackingNumber")
    private String orderTrackingNumber;
}