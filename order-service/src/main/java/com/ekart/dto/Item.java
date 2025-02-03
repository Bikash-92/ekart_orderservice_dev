/**
 * Author: BIKASH
 */

package com.ekart.dto;


import lombok.Data;

@Data
public class Item {
    private int itemId;
    private String nm;
    private int count;
    private double amount;
    private Order orderId;

}
