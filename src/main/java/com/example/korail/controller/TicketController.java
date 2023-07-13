package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @GetMapping("payment")
    public String info_payment() {
        return "/ticket_info/info_payment";
    }

    @GetMapping("refund")
    public String info_refund() {
        return "/ticket_info/info_refund";
    }

    @GetMapping("reservation")
    public String info_reservation() {
        return "ticket_info/info_reservation";
    }
}
