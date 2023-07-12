package com.example.korail.controller;

import com.example.korail.dto.MemberDto;
import com.example.korail.service.MailSendService;
import com.example.korail.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FindController {
    @Autowired
    MemberService memberService;
    @Autowired
    MailSendService mailSendService;

    @GetMapping("findAuth")
    public String mailAuth(){
        return "find_id/find_id1";
    }

    @PostMapping("find_id2")
    public String findid2(HttpSession session, String email, Model model){
        MemberDto mvo = memberService.getFindIdResult(email);
        model.addAttribute("mvo",mvo);
        return "find_id/find_id2";
    }

    @GetMapping("find_pass")
    public String findpass(){
        return "find_pass/find_pass1";
    }

    @PostMapping("find_pass2")
    public String findpass2(HttpSession session, String email,Model model){
        MemberDto mvo = memberService.getFindPassResult(email);

        model.addAttribute("mvo",mvo);

        return "find_pass/find_pass2";
    }
}