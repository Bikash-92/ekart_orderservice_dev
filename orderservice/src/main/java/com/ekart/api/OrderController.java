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
    @ResponseBody
    public ResponseEntity<GenericResponse> publishMessage(@RequestBody Order order);

    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<GenericResponse> checkApi();

}
