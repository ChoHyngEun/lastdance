package com.rainbowsweet.lastdance.controller;

import com.rainbowsweet.lastdance.entity.Member;
import com.rainbowsweet.lastdance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    /*추가해야될것들
     * 회원목록조회 1
     * 권한 관리 기능
     * 멤버쉽 레벨기능
     * 회원 레벨기능
     * admin 회원관리기능*/
    @Autowired
    private MemberService memberService;

    @GetMapping("/search")
    public String searchMembers(@RequestParam("keyword") String keyword, Model model) {
        List<Member> members = memberService.searchMembers(keyword);
        model.addAttribute("members", members);
        return "memberList";
    }
}
