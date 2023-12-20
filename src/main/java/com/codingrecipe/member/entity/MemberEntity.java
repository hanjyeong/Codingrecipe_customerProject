package com.codingrecipe.member.entity;

import com.codingrecipe.member.dto.MemberDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Entity class = 테이블 같은 역할
@Entity
@Setter
@Getter
@Table(name="member_table") //테이블 이름

public class MemberEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(unique = true) //일반 컬럼 + unique 제약 조건 추가
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;


    // dto -> entity 변환해주는 메소드
    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());

        return memberEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }



}
