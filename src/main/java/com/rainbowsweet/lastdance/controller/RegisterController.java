package com.rainbowsweet.lastdance.controller;

import com.rainbowsweet.lastdance.entity.Member;
import com.rainbowsweet.lastdance.repository.MemberRepository;
import com.rainbowsweet.lastdance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    /*
    * RegisterController를 생성하고
    * MemberService와 Member를 주입
    * */

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    /*
    * @GetMapping 어노테이션을 사용하여 회원가입 페이지로 이동하는 메소드를 생성
    * Member 객체를 생성하여 model에 담아 회원가입 페이지로 이동
    * */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    /*
    * @PostMapping 어노테이션을 사용하여 회원가입 요청을 처리하는 메소드를 생성
    * 이 메소드에서는 입력된 회원 정보를 Member 객체에 담아서 MemberService의 saveMember 메소드를 호출하여 회원 정보를 저장
    * 그리고 회원가입 완료 후 로그인 페이지로 이동
    * */
    @PostMapping("/register")
    public String saveMember(@ModelAttribute("member") Member member, Model model) {
        memberService.saveMember(member);
        return "redirect:/login";

    }

    @GetMapping("/secession") //회원탈퇴추가
    public String usersecession(Model model, HttpSession session){
        //로그인한 사용자의 아이디를 가져옴
        String MemberId = (String) session.getAttribute("memberId");

        //탈퇴 로직 구현 (예시)
        boolean deleted = memberService.deleteMember(MemberId);

        if (deleted) {
            //탈퇴가 성공적으로 수행된 경우, 로그아웃 처리를 수행하고, 메인 페이지로 이동합니다.
            session.removeAttribute("memberId");
            return "redirect:/";
        } else {
            //탈퇴가 실패한 경우, 에러 메시지를 출력하고, 마이페이지로 이동합니다.
            model.addAttribute("error", "회원 탈퇴에 실패하였습니다.");
            return "mypage";
        }

    }


}