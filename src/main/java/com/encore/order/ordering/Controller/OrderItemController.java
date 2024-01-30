package com.encore.order.ordering.Controller;

import com.encore.order.ordering.Domain.OrderItem;
import com.encore.order.ordering.Dto.OrderItemResponse;
import com.encore.order.ordering.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/{id}")
    public List<OrderItemResponse> getOrderItemsByOrderId(@PathVariable Long id) {
        List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderingId(id);
        return orderItems.stream()
                .map(orderItem -> new OrderItemResponse(
                        orderItem.getId(),
                        orderItem.getQuantity(),
                        orderItem.getItem().getId(),
                        orderItem.getItem().getName()
                ))
                .collect(Collectors.toList());
    }
}
