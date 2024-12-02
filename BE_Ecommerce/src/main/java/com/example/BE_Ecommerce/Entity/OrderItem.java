package com.example.BE_Ecommerce.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderitems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitemiD")
    private int orderItemId;

    @Column(name = "orderid")
    private int orderId;

    @Column(name = "productid")
    private int productId;

    @Column(name = "Quantity", nullable = false)
    private int quantity;


}