package com.example.korail.controller;

import com.example.korail.dto.OrderDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ReservationlistController {
    @Autowired
    OrderService orderService;
    @GetMapping("admin_main")
    public String admin_main() {

        return "/admin/admin_main";
    }

    @GetMapping("reservation_main")
    public String reservation_main(OrderDto orderDto, HttpSession session, Model model){
        SessionDto svo = (SessionDto)session.getAttribute("svo");

        String id = svo.getId();
        String cardnum = svo.getCardnum();
        String email = svo.getEmail();
        String orderReturn = null;

        if(id == null){
            orderReturn = "reservationlist/login2";
        }

        orderDto.setId(id);
        orderDto.setCardnum(cardnum);
        orderDto.setEmail(email);

        ArrayList<OrderDto> orderList = orderService.getSelect(orderDto);

        if(orderList != null){
            model.addAttribute("orderList",orderList);
            orderReturn = "reservationlist/reservation_main";
        }

        return orderReturn;
    }

    @PostMapping("cardnum_check_proc")
    public String cardnum_check_proc(String cardnum, String userId, String email, HttpSession session,Model model){
        int result = orderService.getCardnum(cardnum,email);
        String orderReturn = null;
        if(result != 0){
            SessionDto svo = new SessionDto();
            svo.setId(userId);
            svo.setCardnum(cardnum);
            svo.setEmail(email);
            session.setAttribute("svo",svo);

            orderReturn = "reservationlist/reservation_main";
        }else {
            orderReturn = "reservationlist/login_fail";
        }
        return orderReturn;
    }
}
