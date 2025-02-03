/**
 * Author: BIKASH
 */
package com.ekart.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Invoice {

    private String CustomerName;
    private String invoiceNo;
    private ShippingAddress shippingAddress;
    private double Amount;
    private Date purchaseDate;


}
