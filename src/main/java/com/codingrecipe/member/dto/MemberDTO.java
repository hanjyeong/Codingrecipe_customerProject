package com.codingrecipe.member.dto;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

    //회원 정보에 필요한 내용들을 필드로 정의
    //html 회원가입 화면에서 사용자에게 입력받는 정보를 계층간의 정보 이동이 쉽도록 DTO클래스의 필드로 설정
    private long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public long getId() {
        return id;
    }
}
