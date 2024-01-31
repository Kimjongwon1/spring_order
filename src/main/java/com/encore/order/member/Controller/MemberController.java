package com.encore.order.member.Controller;

import com.encore.order.member.Domain.Member;
import com.encore.order.member.Dto.MemberListResDto;
import com.encore.order.member.Dto.MemberOrderResDto;
import com.encore.order.member.Dto.MemberSaveReqDto;
import com.encore.order.member.Service.MemberService;
import com.encore.order.ordering.Service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;

    }

    @PostMapping("/new")
    public String memberNew(@RequestBody MemberSaveReqDto memberSaveReqDto){
        memberService.memberSave(memberSaveReqDto);
        return "ok";
    }
    @GetMapping("/members")
    public List<MemberListResDto> memberList() {
        return memberService.findAllMembers().stream()
                .map(member -> new MemberListResDto(
                        member.getId(),
                        member.getName(),
                        member.getAddress())).
                collect(Collectors.toList());
                }

    @GetMapping("/{id}/orders")
    public MemberOrderResDto listMemberOrders(@PathVariable Long id) {
        return memberService.findMemberOrders(id);
    }
}
