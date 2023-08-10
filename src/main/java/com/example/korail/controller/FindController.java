package com.example.korail.controller;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.interceptor.BCrypt;
import com.example.korail.service.MailSendService;
import com.example.korail.service.MemberService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
    public String findpass2(HttpSession session, MemberDto memberDto){

        session.setAttribute("mvo",memberDto);
        return "find_pass/find_pass2";
    }
    @PostMapping("change_proc")
    public String changePass(HttpSession session, @RequestParam String pass){
        MemberDto memberDto = (MemberDto) session.getAttribute("mvo");
        // 새로운 비밀번호를 해시화하여 memberDto에 설정
        memberDto.setPass(BCrypt.hashpw(pass,BCrypt.gensalt(10)));
       /* HashMap<String, String> param = new HashMap<String, String>();
        param.put("memberEmail", memberDto.getEmail());
        param.put("Pass", memberDto.getPass());*/



        // 데이터베이스에 새로운 비밀번호를 업데이트
        memberService.updateMemberPassword(memberDto);
        return "login/login1";
    }


}