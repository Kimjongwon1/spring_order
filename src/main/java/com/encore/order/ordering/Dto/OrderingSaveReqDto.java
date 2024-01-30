package com.encore.order.ordering.Dto;

import com.encore.order.member.Domain.Member;
import com.encore.order.ordering.Domain.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderingSaveReqDto {
    private Long id; // 회원 ID
    private List<Long> itemIds; // 주문할 아이템 ID 목록
    private List<Integer> counts; // 각 아이템의 수량

    public OrderingSaveReqDto(Long id, List<Long> itemIds, List<Integer> counts) {
        this.id = id;
        this.itemIds = itemIds;
        this.counts = counts;
    }
}
