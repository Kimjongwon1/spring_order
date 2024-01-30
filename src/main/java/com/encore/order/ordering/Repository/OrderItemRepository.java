package com.encore.order.ordering.Repository;

import com.encore.order.ordering.Domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderingId(Long id);
}
