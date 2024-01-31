package com.encore.order.ordering.Dto;

import com.encore.order.member.Domain.Member;
import com.encore.order.ordering.Domain.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderingSaveReqDto {
    private Long id;
    private List<Long> itemIds;
    private List<Integer> counts;

    public OrderingSaveReqDto(Long id, List<Long> itemIds, List<Integer> counts) {
        this.id = id;
        this.itemIds = itemIds;
        this.counts = counts;
    }
}
