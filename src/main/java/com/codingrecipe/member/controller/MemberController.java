package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// 회원과 관련된 요청들을 처리하는 컨트롤러
// 회원가입이나 로그인 같은 요청을 경우 Membercontroller에서 동작
@Controller
public class MemberController {

    //생성자 주입
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }


    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {

        //해당 메서드가 제대로 호출이 되는지 확인
        System.out.println("Membercontroller.save");

        // 매개변수로 전달 받은 값들이 제대로 변수에 담겼는지 확인

        System.out.println("memberDto = " + memberDTO);
        memberService.save(memberDTO);

        return "login"; // 로그인 페이지 띄워주기

    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }
}

//@RequestParam("memberEmail") String memberEmail
// save.html에서 memberEmail 이라는 이름의 변수를 매개변수로 받아서 해당 데이터를
// string 형식의 memberEmail에 넣어라