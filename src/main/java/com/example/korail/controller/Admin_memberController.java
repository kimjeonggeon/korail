package com.example.korail.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.PageDto;
import com.example.korail.service.MemberService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class Admin_memberController {
	@Autowired
	 MemberService memberService;
	@Autowired
	PageService pageService;

	@PostMapping("/admin_member_search")
	public String admin_member_search(PageDto pageDto, Model model) {
		pageDto.setServiceName("member");
		if(pageDto.getCategory().equals("total")){
			pageDto=pageService.getPageResult(pageDto);
			model.addAttribute("list", memberService.list(pageDto));
			model.addAttribute("page", pageDto);
		}else {
			pageDto=pageService.getPageResult(pageDto);
			model.addAttribute("list",memberService.search_list(pageDto));
			model.addAttribute("page", pageDto);
		}
		return "/admin/admin_member_list";

	}


	@GetMapping("member_list/{page}")
	public String admin_member_list(@PathVariable String page, Model model) {
		PageDto pageDto = pageService.getPageResult(new PageDto(page, "member"));
		model.addAttribute("list", memberService.list(pageDto));
		model.addAttribute("page", pageDto);

		return "/admin/admin_member_list";
	}

}
