package com.encore.order.ordering.Service;

import com.encore.order.ordering.Domain.OrderItem;
import com.encore.order.ordering.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    @Transactional
    public List<OrderItem> findOrderItemsByOrderingId(Long id) {
        return orderItemRepository.findByOrderingId(id);
    }
}
