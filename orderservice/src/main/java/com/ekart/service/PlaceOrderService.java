/**
 * Author: BIKASH
 */
package com.ekart.service;


import com.ekart.dto.GenericResponse;
import com.ekart.dto.Order;


public interface PlaceOrderService {

     GenericResponse placeOrder(Order order);

}
