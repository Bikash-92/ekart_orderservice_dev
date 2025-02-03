/**
 * Author: BIKASH
 */
package com.ekart.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shipping_address")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name="zip_code")
    private int zipCode;
    @Column(name="state")
    private String state;

}
