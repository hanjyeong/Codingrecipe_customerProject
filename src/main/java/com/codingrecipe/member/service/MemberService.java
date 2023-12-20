package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.entity.MemberEntity;
import com.codingrecipe.member.repository.MemberRepository;

import org.springframework.stereotype.Service;

@Service // 스프링이 관리 해주는 객체

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출 (조건. entity객체로 넘겨줘야함)
//        1. dto -> entity 로 변환
//        2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}
