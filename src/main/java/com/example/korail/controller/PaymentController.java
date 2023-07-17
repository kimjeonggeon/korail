package com.example.korail.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/spurchase")
    public String simple_purchased() {
        return "/payment_history/s_reservation";
    }

    @GetMapping("/preferential_proc")
    public String preferential_proc (HttpSession session, MemberDto memberDto) {
        HashMap<String, String> param = new HashMap<>();

        SessionDto svo = (SessionDto) session.getAttribute("svo");
        String id = svo.getId();

        param.put("id", id);
        param.put("preferential", String.valueOf(memberDto.getPreferential()));
        pmyhisService.preferential(param);

        return "index";
    }
}