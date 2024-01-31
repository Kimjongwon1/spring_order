package com.encore.order.ordering.Dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long orderItemId;
    private int quantity;
    private Long itemId;
    private String itemName;


    public OrderItemResponse(Long orderItemId, int quantity, Long itemId, String itemName) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.itemId = itemId;
        this.itemName = itemName;
    }
}
