package com.encore.order.ordering.Dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long orderItemId;
    private int quantity;
    private Long itemId;
    private String itemName;
    // 필요한 다른 필드들을 추가할 수 있습니다.

    public OrderItemResponse(Long orderItemId, int quantity, Long itemId, String itemName) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.itemId = itemId;
        this.itemName = itemName;
    }
}
