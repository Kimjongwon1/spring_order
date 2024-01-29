package com.encore.order.member.Service;

import com.encore.order.member.Domain.Member;
import com.encore.order.member.Domain.Role;
import com.encore.order.member.Dto.MemberListResDto;
import com.encore.order.member.Dto.MemberSaveReqDto;
import com.encore.order.member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){this.memberRepository = memberRepository;}

    @Transactional
    public void memberSave(MemberSaveReqDto memberSaveReqDto) throws IllegalArgumentException{
        Role role;
        if (memberSaveReqDto.getRole() == null || memberSaveReqDto.getRole().equalsIgnoreCase("user")) {
            role = Role.USER;
        } else {
            role = Role.ADMIN;
        }
        Member member = Member.builder()
                .name(memberSaveReqDto.getName())
                .email(memberSaveReqDto.getEmail())
                .password(memberSaveReqDto.getPassword())
                .address(memberSaveReqDto.getAddress())
                .role(role)
                .build();

        memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
