/**
 * Author: BIKASH
 */
package com.ekart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "order_request")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "invoice_no")
    private String invoice;
    @OneToMany(mappedBy = "orderNumber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
    @Column(name = "status")
    private String status;
    @Column(name = "total_amount")
    private double totalAmount;
    @OneToOne(cascade = CascadeType.ALL) // Cascade operations
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "id")
    private ShippingAddress shippingAddress;

}
