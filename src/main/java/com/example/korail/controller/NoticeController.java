package com.example.korail.controller;

import com.example.korail.dto.PageDto;
import com.example.korail.service.NoticeService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @Autowired
    PageService pageService;

    @GetMapping("notice_list/{category}/{cvalue}/{page}")
    public String notice_list(@PathVariable String category, @PathVariable String cvalue, @PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(category, cvalue, page,"notice"));
        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("category", pageDto);
        model.addAttribute("cvalue", pageDto);
        model.addAttribute("page", pageDto);
        return "/notice/notice_list";
    }

    @GetMapping("notice_content/{nid}/{page}")
    public String notice_content(@PathVariable String nid, @PathVariable String page, Model model) {
        model.addAttribute("notice", noticeService.content(nid));
        model.addAttribute("page", page);
        return "/notice/notice_content";
    }
}
