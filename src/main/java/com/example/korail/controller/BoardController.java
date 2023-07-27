package com.example.korail.controller;

import com.example.korail.dto.PageDto;
import com.example.korail.service.BoardService;
import com.example.korail.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    @Autowired
    PageService pageService;
    @Autowired
    BoardService boardService;

    @GetMapping("board_content")
    public String board_content(){
        return "board/board_content";
    }

    @GetMapping("board_list/{page}")
    public String board_list(Model model, @PathVariable String page){
        PageDto pageDto = pageService.getPageResult(new PageDto(page,"board"));
        model.addAttribute("list",boardService.list(pageDto));
        model.addAttribute("page",pageDto);
        return "board/board_list";
    }


}
