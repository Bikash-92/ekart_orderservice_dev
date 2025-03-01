/**
 * Author: BIKASH
 */
package com.ekart.api;


import com.ekart.dto.GenericResponse;
import com.ekart.dto.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
public interface OrderController {

    @PostMapping("/place-order")
    ResponseEntity<GenericResponse> publishMessage(@RequestBody Order order);

    @GetMapping("/ping")
    ResponseEntity<GenericResponse> checkApi();


}
