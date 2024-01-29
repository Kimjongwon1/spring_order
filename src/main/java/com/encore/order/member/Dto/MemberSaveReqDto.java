package com.encore.order.member.Dto;

import lombok.Data;

@Data
public class MemberSaveReqDto {
     private String name;
     private String password;
     private String email;
     private String address;
     private String role;
}
