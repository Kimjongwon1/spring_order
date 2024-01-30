package com.encore.order.member.Controller;

import com.encore.order.member.Dto.MemberOrderResDto;
import com.encore.order.member.Dto.MemberSaveReqDto;
import com.encore.order.member.Service.MemberService;
import com.encore.order.ordering.Service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final OrderingService orderingService;

    @Autowired
    public MemberController(MemberService memberService, OrderingService orderingService) {
        this.memberService = memberService;
        this.orderingService = orderingService;
    }

    @PostMapping("/new")
    public String memberNew(@RequestBody MemberSaveReqDto memberSaveReqDto){
        memberService.memberSave(memberSaveReqDto);
        return "ok";
    }
    @GetMapping("/members")
    public ResponseEntity<?> memberList() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @GetMapping("/{id}/orders")
    public MemberOrderResDto listMemberOrders(@PathVariable Long id) {
        return memberService.findMemberOrders(id);
    }
}
