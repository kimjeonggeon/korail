package com.example.korail.controller;

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

    @GetMapping("notice_list_json")
    public String notice_list() {
        return "/notice/notice_list_json";
    }

    @GetMapping("notice_content/{nid}/{page}")
    public String notice_content(@PathVariable String nid, @PathVariable String page, Model model) {
        model.addAttribute("notice", noticeService.content(nid));
        model.addAttribute("page", page);
        return "/notice/notice_content";
    }
}
