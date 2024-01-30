package com.encore.order.ordering.Service;

import com.encore.order.member.Domain.Member;
import com.encore.order.member.Repository.MemberRepository;
import com.encore.order.ordering.Domain.Item;
import com.encore.order.ordering.Domain.OrderItem;
import com.encore.order.ordering.Domain.OrderStatus;
import com.encore.order.ordering.Domain.Ordering;
import com.encore.order.ordering.Dto.OrderingSaveReqDto;
import com.encore.order.ordering.Repository.ItemRepository;
import com.encore.order.ordering.Repository.OrderItemRepository;
import com.encore.order.ordering.Repository.OrderingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderingService {
    private final OrderingRepository orderingRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderingService(OrderingRepository orderingRepository, MemberRepository memberRepository, ItemRepository itemRepository, OrderItemRepository orderItemRepository) {
        this.orderingRepository = orderingRepository;
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Ordering> findAllOrders() {
        return orderingRepository.findAll();
    }

    @Transactional
    public void createOrder(OrderingSaveReqDto reqDto) {
        Member member = memberRepository.findById(reqDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        Ordering ordering = Ordering.builder()
                .member(member)
                .orderStatus(OrderStatus.ORDERED)
                .build();
        ordering = orderingRepository.save(ordering);

        for (int i = 0; i < reqDto.getItemIds().size(); i++) {
            Long itemId = reqDto.getItemIds().get(i);
            int quantity = reqDto.getCounts().get(i);

            Item item = itemRepository.findById(itemId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));

            if (item.getStockQuantity() < quantity) {
                throw new IllegalArgumentException("Insufficient stock for item ID: " + itemId);
            }

            item.setstock(item.getStockQuantity() - quantity);
            itemRepository.save(item);

            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .ordering(ordering)
                    .quantity(quantity)
                    .build();
            orderItemRepository.save(orderItem);
        }
    }
    @Transactional
    public void cancelOrder(Long id) {
        Ordering ordering = orderingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order ID"));

        if (ordering.getOrderStatus() == OrderStatus.CANCELED) {
            throw new IllegalStateException("Order is already canceled");
        }


        ordering.setOrderStatus(OrderStatus.CANCELED);

        orderingRepository.save(ordering);
    }

}
