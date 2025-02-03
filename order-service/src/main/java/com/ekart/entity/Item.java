/**
 * Author: BIKASH
 */
package com.ekart.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(name = "name")
    private String nm;
    @Column(name = "unit")
    private int count;
    @Column(name = "amount")
    private double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_number")
    private Order orderNumber;

}
