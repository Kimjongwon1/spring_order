package com.encore.order.ordering.Repository;

import com.encore.order.ordering.Domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Ordering,Long> {
}
