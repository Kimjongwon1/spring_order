package com.encore.order.ordering.Service;

import com.encore.order.ordering.Domain.Ordering;
import com.encore.order.ordering.Repository.OrderingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderingService {
    private final OrderingRepository orderingRepository;

    public OrderingService(OrderingRepository orderingRepository) {
        this.orderingRepository = orderingRepository;
    }

    public List<Ordering> findAllOrders() {
        return orderingRepository.findAll();
    }
}
