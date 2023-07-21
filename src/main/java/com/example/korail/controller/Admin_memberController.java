package com.example.korail.controller;

import java.util.ArrayList;
import java.util.Map;

import com.example.korail.dto.PageDto;
import com.example.korail.service.MemberService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/*@Controller
@RequestMapping("admin")
public class Admin_memberController {
	@Autowired
	 MemberService memberService;
	@Autowired
	PageService pageService;*/
/*
	@GetMapping("member_list/{page}")
	public ModelAndView admin_member_search(@PathVariable String page, String category, String cvalue) {
		Map<String, Integer> param = null;
		
		ModelAndView model = new ModelAndView();
		if(category.equals("total")){
			param = pageService.getPageResult(page, "member");
		}else {
			param = pageService.getPageResult(page, "member", category, cvalue);		
			
		}
		ArrayList<MemberVo> list 
		= memberService.getList(param.get("startCount"), param.get("endCount"),category, cvalue);
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/admin_member_list");
		
		return model;
	}*/

	
/*

	@GetMapping(value="/admin_member/")
	public String admin_member_list(@PathVariable String page, Model model) {
		PageDto pageDto = pageService.getPageResult(page, "member","all","all");
		ArrayList<MemberVo> list 
			= memberService.getList(param.get("startCount"), param.get("endCount"));
		System.out.println(param.get("dbCount"));
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/admin_member_list");
		
		return model;
	}
		
}
*/
