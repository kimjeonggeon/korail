package com.example.korail.controller;

import com.example.korail.dto.PageDto;
import com.example.korail.service.MailSendService;
import com.example.korail.service.MemberService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class Aimin_memberController {
    @Autowired
    MemberService memberService;

    @Autowired
    PageService pageService;

    @PostMapping("admin_member_search/{page}")
    public String admin_member_serch(Model model,@PathVariable String page,String category,String cvalue){
        PageDto pageDto = null;

        if(category.equals("total")){
             pageDto = pageService.getPageResult2(new PageDto(page,"member"));
        }else{
             pageDto = pageService.getPageResult4(new PageDto(page,"member"),category,cvalue);
        }

        model.addAttribute("list", memberService.list(pageDto));
        model.addAttribute("page",pageDto);


        return "admin/admin_member_list";
    }

    @GetMapping("admin_member/{page}")
    public String admin_member_list(@PathVariable String page, Model model){
        PageDto pageDto = pageService.getPageResult4(new PageDto(page,"member"),"all","all");
        model.addAttribute("list", memberService.list(pageDto));
        model.addAttribute("page",pageDto);
        return "admin/admin_member_list";
    }
}
