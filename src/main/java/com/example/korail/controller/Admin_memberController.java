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


@Controller
@RequestMapping("admin")
public class Admin_memberController {
	@Autowired
	 MemberService memberService;
	@Autowired
	PageService pageService;

	/*@GetMapping("member_list/{category}/{cvalue}/{page}")
	public ModelAndView admin_member_search(@PathVariable String page, @PathVariable String category, @PathVariable String cvalue) {
		Map<String, Integer> param = null;

		ModelAndView model = new ModelAndView();
		if(category.equals("total")){
			PageDto pageDto = pageService.getPageResult(new PageDto(page, "member"));
		}else {
			param = pageService.getPageResult(new PageDto(page,"member",category,cvalue));

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
	}
*/
	


	@GetMapping(value="member_list/{page}")
	public String admin_member_list(@PathVariable String page, Model model) {
		PageDto pageDto = pageService.getPageResult(new PageDto(page, "member"));
		model.addAttribute("list", memberService.list(pageDto));
		model.addAttribute("page", pageDto);

		return "/admin/admin_member_list";
	}

}
