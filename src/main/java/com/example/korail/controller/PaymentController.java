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

    @GetMapping("/myreservation_receipt")
    @ResponseBody
    public String reservation_receipt(String reservnum, Model model) {

        OrderDto orderVo = pmyhisService.getInfo(reservnum);

        model.addAttribute("ovo", orderVo);

        return "/payment_history/payment_receipt";
    }

    @GetMapping("/paycal")
    public String paycal() {

        return "/payment_history/calender";
    }

    @GetMapping("/paypment_json_data/{date1Str}/{date2Str}/{checked}")
    @ResponseBody
    public String plahis_json_data(HttpSession session, @PathVariable String date1Str, @PathVariable String date2Str, @PathVariable String checked) {
        HashMap<String, String> param = new HashMap<String, String>();
		//a s
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        String id = svo.getId();
		String ab ="";
        param.put("id", id);
        param.put("date1", date1Str);
        param.put("date2", date2Str);
        param.put("status", checked);
        ArrayList<OrderDto> list
                = pmyhisService.getSelect(param);

        JsonObject jlist = new JsonObject();
        JsonArray jarray = new JsonArray();

        for (OrderDto phv : list) {
            JsonObject jobj = new JsonObject();  //{}
            jobj.addProperty("rdate", phv.getRdate()); //{rno:1}
            jobj.addProperty("sstation", phv.getSstation());
            jobj.addProperty("dstation", phv.getDstation());
            jobj.addProperty("stime", phv.getStime());
            jobj.addProperty("price", phv.getPrice());
            jobj.addProperty("qty", phv.getTicketqty());
            jobj.addProperty("time", phv.getDepPlandTime());
            jobj.addProperty("status", phv.getCancel());
            jobj.addProperty("rnum", phv.getReservnum());
            jarray.add(jobj);
        }
        jlist.add("jlist", jarray);
//	System.out.println(jlist.toString());
        return new Gson().toJson(jlist);
    }
}