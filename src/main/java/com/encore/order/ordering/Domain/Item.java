package com.encore.order.ordering.Domain;

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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int stockQuantity;
    private String imagePath;
    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("1개 이상 입력하시오");
        }
        this.price = price;
    }

    public void setstock(int stockQuantity) {
        if (stockQuantity <= 0) {
            throw new IllegalArgumentException("1개 이상 입력하시오");
        }
        this.stockQuantity = stockQuantity;
    }
    @Builder
    public Item(Long id, String name, int price, int stockQuantity, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imagePath = imagePath;
    }
}
