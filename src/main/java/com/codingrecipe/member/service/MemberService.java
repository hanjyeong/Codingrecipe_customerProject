package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.entity.MemberEntity;
import com.codingrecipe.member.repository.MemberRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // 스프링이 관리 해주는 객체

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }


    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출 (조건. entity객체로 넘겨줘야함)
        // 1. dto -> entity 로 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
