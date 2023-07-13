package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("train")
public class TrainController {

    @GetMapping("timetable")
    public String train_timetable() {
        return "/train_info/train_timetable";
    }

    @GetMapping("route_info")
    public String train_route_info() {
        return "/train_info/train_route_info";
    }
}
