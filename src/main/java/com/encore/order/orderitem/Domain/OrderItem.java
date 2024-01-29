package com.encore.order.orderitem.Domain;

import com.encore.order.item.Domain.Item;
import com.encore.order.ordering.Domain.Ordering;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordering_id", nullable = false)
    private Ordering ordering;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public void setquantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("1개 이상 입력하시오");
        }
        this.quantity = quantity;
    }
    @Builder
    public OrderItem(Long id, int quantity, Item item, Ordering ordering) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.ordering = ordering;
    }
}
