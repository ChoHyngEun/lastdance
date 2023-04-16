package com.rainbowsweet.lastdance.controller;

import com.rainbowsweet.lastdance.entity.Member;
import com.rainbowsweet.lastdance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    //멤버서비스 가져오기
    @Autowired
    private MemberService memberService;

    //겟매핑--login 인터페이스 요청
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    //로그인 버튼 누를시 행동
    @PostMapping("/login")
    public String authenticate(@RequestParam("memberId") String memberId,
                               @RequestParam("password") String password,
                               HttpServletRequest request,
                               Model model) {
        String encodedPassword = encodePassword(password);
        Member member = memberService.authenticate(memberId, encodedPassword);
        if (member != null) {
            request.getSession().setAttribute("member", member);
            memberService.incrementLoginCount(member);
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }
    }

    //겟매핑-- 마이페이지 인터페이스 요청
    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request, Model model) {
        Member member = (Member) request.getSession().getAttribute("member");
        if (member != null) {
            model.addAttribute("member", member);
            return "mypage";
        } else {
            return "redirect:/";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    //비밀번호 데이터베이스 암호화
    private String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
