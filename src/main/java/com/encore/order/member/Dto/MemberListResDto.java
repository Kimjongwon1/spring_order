package com.encore.order.member.Dto;

import lombok.Data;

@Data
public class MemberListResDto {
    private Long id;
    private String name;
    private String address;
    public MemberListResDto(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


}
