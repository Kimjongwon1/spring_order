package com.encore.order.member.Dto;

import com.encore.order.ordering.Domain.Ordering;
import lombok.Data;

import java.util.List;

@Data
public class MemberOrderResDto {
     private Long id;
     private String name;
     private String email;
     private String address;
     private String role;
     private List<Ordering> orderings;
}
