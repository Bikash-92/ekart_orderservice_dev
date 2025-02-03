/**
 * Author: BIKASH
 */
package com.ekart.dto;

import lombok.Data;

import java.util.List;


@Data
public class Order {
    private int orderId;
    private List<Item> items;
    private String status;
    private double totalAmount;
    private String invoice;
    private ShippingAddress shippingAddress;

   }
