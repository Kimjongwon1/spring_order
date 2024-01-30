package com.encore.order.ordering.Dto;

import com.encore.order.ordering.Domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderingListResDto {

    private Long id;
    private String memberName;
    private OrderStatus orderStatus;
    private LocalDateTime createdTime;

    public OrderingListResDto(Long id, String memberName, OrderStatus orderStatus, LocalDateTime createdTime) {
        this.id = id;
        this.memberName = memberName;
        this.orderStatus = orderStatus;
        this.createdTime = createdTime;
    }
}
