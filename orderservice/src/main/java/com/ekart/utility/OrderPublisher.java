package com.ekart.utility;


import com.ekart.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher {

    private static final String TOPIC = "order-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishOrderDetails(Order order) {
        kafkaTemplate.send(TOPIC, order);
    }

}
