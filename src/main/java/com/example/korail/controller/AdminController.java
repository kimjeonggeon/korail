package com.example.korail.controller;

import com.example.korail.dto.PageDto;
import com.example.korail.service.FileService;
import com.example.korail.service.NoticeService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    @Autowired
    PageService pageService;

    @Autowired
    NoticeService noticeService;

    @Autowired
    FileService fileService;

    @GetMapping("admin_notice_list/{category}/{cvalue}/{page}")
    public String admin_notice_list(@PathVariable String category, @PathVariable String cvalue, @PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(category, cvalue, page, "notice"));
        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("page", pageDto);
        return "/admin/admin_notice_list";
    }

    @GetMapping("admin_notice_content")
    public String admin_notice_content() {
        return "/admin/admin_notice_content";
    }

    @GetMapping("admin_notice_write")
    public String admin_notice_write() {
        return "/admin/admin_notice_write";
    }

    @GetMapping("admin_notice_update")
    public String admin_notice_update() {
        return "/admin/admin_notice_update";
    }

    @GetMapping("admin_notice_delete")
    public String admin_notice_delete() {
        return "/admin/admin_notice_delete";
    }
}
