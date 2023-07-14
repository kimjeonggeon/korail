package com.example.korail.controller;

import com.example.korail.dto.ReservationDto;
import com.example.korail.dto.SeatNumberDto;
import com.example.korail.dto.UpdateDto;
import com.example.korail.service.MailSendService;
import com.example.korail.service.MemberService;
import com.example.korail.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class KorailRestControlloer {
    @Autowired
    OrderService orderService;

    @Autowired
    MemberService memberService;

    @Autowired
    MailSendService mailSendService;


    @GetMapping("mailCheck/{email}")
    public String mailCheck(@PathVariable String email){
        return mailSendService.mailCheck(email);
    }


    @GetMapping("train_reservation_satschc_json")
    public String train_reservation_satschc_json(HttpSession session, String trnumber){
        ReservationDto rvo = (ReservationDto)session.getAttribute("rvo");
        rvo.setTrnumber(trnumber);
        ArrayList<SeatNumberDto> list =(ArrayList<SeatNumberDto>)orderService.getSeatnum(rvo);
        JsonArray seatList = new JsonArray();
        JsonObject slist = new JsonObject();

        for(SeatNumberDto seatDto : list){
            String chairNum = seatDto.getChairnum();
            String[] chairNumArray = chairNum.split(",");

            for(String chair : chairNumArray){
                String seatNum = chair.substring(3,5);
                JsonObject jobj = new JsonObject();
                jobj.addProperty("seat", seatNum);
                seatList.add(jobj);
            }
        }
        slist.add("seatList",seatList);

        return new Gson().toJson(slist);
    }

    @GetMapping("reservationlist_update_chair_json/{trnumber}")
    public String reservationlist_update_chair_json(HttpSession session, @PathVariable String trnumber){
        UpdateDto uvo = (UpdateDto)session.getAttribute("uvo");
        uvo.setTrnumber(trnumber);
        ArrayList<SeatNumberDto> list =(ArrayList<SeatNumberDto>)orderService.getSeatnumUp(uvo);
        JsonArray seatList = new JsonArray();
        JsonObject slist = new JsonObject();

        for(SeatNumberDto seatDto : list){
            String chairNum = seatDto.getChairnum();
            String[] chairNumArray = chairNum.split(",");

            for(String chair : chairNumArray){
                String seatNum = chair.substring(4,6);
                JsonObject jobj = new JsonObject();
                jobj.addProperty("seat", seatNum);
                seatList.add(jobj);
            }
        }
        slist.add("seatList",seatList);

        return new Gson().toJson(slist);
    }

    @GetMapping("id_check")
    public String id_check(String id){
        int result = memberService.getIdCheckResult(id);
        return String.valueOf(result);
    }

    @GetMapping("email_check")
    public String email_check(String email){
        int result = memberService.getEmailCheckResult(email);
        return String.valueOf(result);
    }


    @GetMapping("reservCancel_check/{reservnum}")
    public String reservCancel_check(@PathVariable String reservnum){
        return orderService.getCancelResult(reservnum);
    }




}
