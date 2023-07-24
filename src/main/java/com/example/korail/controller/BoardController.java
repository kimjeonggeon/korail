package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("board_list")
    public String board_list(){

        return "board/board_list";
    }

    @GetMapping("board_content")
    public String board_content(){
        return "board/board_content";
    }
}
