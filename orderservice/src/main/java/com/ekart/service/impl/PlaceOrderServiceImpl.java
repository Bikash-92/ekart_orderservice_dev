package com.ekart.service.impl;


import com.ekart.constant.ExecutionStatus;
import com.ekart.dto.GenericResponse;
import com.ekart.dto.Item;
import com.ekart.dto.Order;
import com.ekart.repository.OrderRepository;
import com.ekart.service.PlaceOrderService;
import com.ekart.utility.GenericResponseFactory;
import com.ekart.utility.Mapper;
import com.ekart.utility.OrderPublisher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PlaceOrderServiceImpl implements PlaceOrderService {
    Logger logger = LoggerFactory.getLogger(PlaceOrderServiceImpl.class);

    @Autowired
    private OrderPublisher orderPublisher;

    @Autowired
    private GenericResponseFactory genericResponseFactory;

    @Autowired
    private OrderRepository orderRepository;



    @Override
    public GenericResponse placeOrder(Order order) {
        logger.info("OrderDetails {}", order);
        boolean isDataPersist = persistData(order);
        if(isDataPersist) {
            logger.info("Publishing the requested order...");
            CompletableFuture.runAsync(() -> {
                orderPublisher.publishOrderDetails(order);
            });
            logger.info("Order has been published!!");
        }
        return genericResponseFactory.constructGenericResponse("Order has been published!!","65535", new Object(), new ArrayList<>());
    }

    public boolean persistData(Order orderDto){
        boolean isDataPersist = false;
        try{
            orderDto.setTotalAmount(orderDto.getItems().stream().map(Item::getAmount).reduce(0.0,(a, b)->(a+b)));
            orderDto.setInvoice(generateInvoice());
            orderDto.setStatus(ExecutionStatus.IN_PROGRESS.getCode());
            com.ekart.entity.Order order = orderRepository.save(Mapper.mapOrderDtoToEntity(orderDto));
            orderDto = Mapper.mapOrderEntityToDTO(order);
            logger.info("persistData -  {}",orderDto);
            isDataPersist = true;
        }catch (Exception ex){
            logger.error("exception {}", ex);
        }
        return isDataPersist;
    }

    public String generateInvoice(){
        int randomNumber = (int) (Math.random() * 10) + 1;
        UUID uuid = UUID.randomUUID();
        return "INV_"+uuid;
    }
}
