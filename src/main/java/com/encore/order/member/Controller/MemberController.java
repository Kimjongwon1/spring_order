package com.encore.order.member.Controller;

import com.encore.order.member.Dto.MemberListResDto;
import com.encore.order.member.Dto.MemberSaveReqDto;
import com.encore.order.member.Service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> memberNew(@RequestBody MemberSaveReqDto memberSaveReqDto){
        memberService.memberSave(memberSaveReqDto);
        return ResponseEntity.ok("ok");
    }


    @GetMapping("/members")
    public ResponseEntity<?> memberList() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }
}
