package com.encore.order.ordering.Repository;

import com.encore.order.ordering.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
