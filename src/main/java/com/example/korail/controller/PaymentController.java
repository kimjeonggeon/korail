package com.example.korail.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.example.korail.dto.OrderDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class PaymentController {

    @Autowired
    private PmyhisService pmyhisService;

    @GetMapping("/pmyhis")
    public String pmyhis() {

        return "/payment_history/payment_history_view";
    }

    @GetMapping("/myreservation_receipt/{reservnum}")
    @ResponseBody
    public String reservation_receipt(@PathVariable String reservnum, Model model) {

        OrderDto orderDto = pmyhisService.getInfo(reservnum);

        model.addAttribute("ovo", orderDto);

        return "/payment_history/payment_receipt";
    }

    @GetMapping("/paycal")
    public String paycal() {

        return "/payment_history/calender";
    }

    @GetMapping("/paypment_json_data/{date1Str}/{date2Str}/{checked}")
    @ResponseBody
    public ArrayList<OrderDto> plahis_json_data(HttpSession session, @PathVariable String date1Str, @PathVariable String date2Str, @PathVariable String checked) {
        // service 데이터 전송 객체 생성
        HashMap<String, String> param = new HashMap<String, String>();

        // 해당 객체에 id, 조회시작일, 조회종료일, 상태 입력
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        String id = svo.getId();
        
        param.put("id", id);
        param.put("date1", date1Str);
        param.put("date2", date2Str);
        param.put("cancel", checked);

        // 결제내역 데이터를 ArrayList 형태로 수령
        ArrayList<OrderDto> Dtlist
                = pmyhisService.getSelect(param);

        // aJax에 해당 데이터 리턴
        return Dtlist;
    }
}