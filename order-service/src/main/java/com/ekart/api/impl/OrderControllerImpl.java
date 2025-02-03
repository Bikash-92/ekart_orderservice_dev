/**
 * Author: BIKASH
 */
package com.ekart.api.impl;

import com.ekart.api.OrderController;
import com.ekart.dto.GenericResponse;
import com.ekart.dto.Order;
import com.ekart.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderControllerImpl implements OrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @Override
    public ResponseEntity<GenericResponse> publishMessage(Order order) {
        GenericResponse genericResponse = placeOrderService.placeOrder(order);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> checkApi() {
        System.out.println("Working...");
        return null;
    }


}
