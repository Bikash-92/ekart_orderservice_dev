/**
 * Author: BIKASH
 */
package com.ekart.utility;

import com.ekart.dto.Item;
import com.ekart.dto.Order;
import com.ekart.dto.ShippingAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static com.ekart.entity.Order mapOrderDtoToEntity(Order orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        com.ekart.entity.Order order = new com.ekart.entity.Order();
        order.setStatus(orderDTO.getStatus());
        order.setShippingAddress(mapShippingAddressDtoToEntity(orderDTO.getShippingAddress()));
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setInvoice(orderDTO.getInvoice());
        List<com.ekart.entity.Item> itemList = orderDTO.getItems().stream().map(Mapper::mapItemDtoToEntity).toList();
        order.setItems(itemList);
        return order;
    }

    public static com.ekart.entity.ShippingAddress mapShippingAddressDtoToEntity(ShippingAddress shippingAddressDTO){
        if (shippingAddressDTO == null) {
            return null;
        }
        com.ekart.entity.ShippingAddress shippingAddress = new com.ekart.entity.ShippingAddress();
        shippingAddress.setCity(shippingAddressDTO.getCity());
        shippingAddress.setName(shippingAddressDTO.getName());
        shippingAddress.setState(shippingAddressDTO.getState());
        shippingAddress.setZipCode(shippingAddressDTO.getZipCode());
        return shippingAddress;
    }

    public static  com.ekart.entity.Item mapItemDtoToEntity(Item itemDto){
        if (itemDto == null) {
            return null;
        }
        com.ekart.entity.Item item = new com.ekart.entity.Item();
        item.setAmount(itemDto.getAmount());
        item.setCount(itemDto.getCount());
        item.setNm(itemDto.getNm());
        return item;
    }



    public static Order mapOrderEntityToDTO(com.ekart.entity.Order orderEntity) {
        if (orderEntity == null) {
            return null;
        }

        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setStatus(orderEntity.getStatus());
        order.setInvoice(orderEntity.getInvoice());
        order.setShippingAddress(mapShippingAddressEntityToDTO(orderEntity.getShippingAddress()));
        List<Item> itemList = orderEntity.getItems().stream().map(Mapper::mapItemEntityToDTO).toList();
        order.setItems(itemList);
        order.setTotalAmount(orderEntity.getTotalAmount());
        return order;
    }

    public static ShippingAddress mapShippingAddressEntityToDTO(com.ekart.entity.ShippingAddress shippingAddressEntity){
        if (shippingAddressEntity == null) {
            return null;
        }
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity(shippingAddressEntity.getCity());
        shippingAddress.setName(shippingAddressEntity.getName());
        shippingAddress.setState(shippingAddressEntity.getState());
        shippingAddress.setZipCode(shippingAddressEntity.getZipCode());
        return shippingAddress;
    }

    public static Item mapItemEntityToDTO(com.ekart.entity.Item itemEntity){
        if (itemEntity == null) {
            return null;
        }
        Item item = new Item();
        item.setItemId(item.getItemId());
        item.setAmount(itemEntity.getAmount());
        item.setCount(itemEntity.getCount());
        item.setNm(itemEntity.getNm());
        return item;
    }


}
