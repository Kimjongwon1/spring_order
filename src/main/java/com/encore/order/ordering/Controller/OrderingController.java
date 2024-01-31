package com.encore.order.ordering.Controller;

import com.encore.order.ordering.Domain.Ordering;
import com.encore.order.ordering.Dto.OrderingListResDto;
import com.encore.order.ordering.Dto.OrderingSaveReqDto;
import com.encore.order.ordering.Service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordering")
public class OrderingController {
    private final OrderingService orderingService;

    @Autowired
    public OrderingController(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @PostMapping("/new")
    public String orderNew(@RequestBody OrderingSaveReqDto orderingSaveReqDto){
            orderingService.createOrder(orderingSaveReqDto);
            return "ok";
    }

    @GetMapping("/orders")
    public List<OrderingListResDto> getAllOrders() {
        return orderingService.findAllOrders().stream()
                .map(ordering -> new OrderingListResDto(
                        ordering.getId(),
                        ordering.getMember().getName(),
                        ordering.getOrderStatus(),
                        ordering.getCreatedTime()))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}/cancel")
    public String cancelOrder(@PathVariable Long id) {
        orderingService.cancelOrder(id);
        return "ok";
    }
}
