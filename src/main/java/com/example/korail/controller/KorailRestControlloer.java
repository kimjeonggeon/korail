package com.example.korail.controller;

import com.example.korail.dto.*;
import com.example.korail.service.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KorailRestControlloer {
    @Autowired
    OrderService orderService;

    @Autowired
    MemberService memberService;

    @Autowired
    MailSendService mailSendService;

    @Autowired
    NoticeService noticeService;

    @Autowired
    PageService pageService;


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

    @GetMapping("notice_list_json_data/{page}/")
    public Map notice_list_json_data(@PathVariable String page) {
        Map map = new HashMap();
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"));
        List<NoticeDto> list = noticeService.list(pageDto);

        map.put("list", list);
        map.put("page", pageDto);

        return map;
    }

    @GetMapping("notice_content_json_data/{nid}")
    public NoticeDto notice_content_json_data(@PathVariable String nid) {
        Map map = new HashMap();
        NoticeDto noticeDto = noticeService.content(nid);
        ArrayList<NoticeDto> nlist = noticeService.getNid(nid);

        int pidx = 0;
        int nidx = 0;
        int idx = 0;

        for(int i=0; i<nlist.size(); i++) {
            NoticeDto nvo = nlist.get(i);
            if(nvo.getNid().equals(nid)) {
                idx = i;
                if(idx == 0) {
                    pidx = nlist.size()-1;
                    nidx = idx+1;
                } else if(idx == nlist.size()-1) {
                    pidx = idx-1;
                    nidx = 0;
                } else {
                    pidx = idx-1;
                    nidx = idx+1;
                }
            }
        }
        if(noticeService.content(nid) != null) {
            noticeService.updateHits(nid);
        }

        map.put("noticeDto", noticeDto);
        map.put("nprev", nlist.get(pidx).getNid());
        map.put("nnext", nlist.get(nidx).getNid());

        return noticeDto;
    }

    @GetMapping("notice_search_json_data/{category}/{cvalue}/{page}")
    public Map notice_search_json_data(@PathVariable String category, @PathVariable String cvalue, @PathVariable String page) {
//        System.out.println("category ==> " + category);
//        System.out.println("cvalue  ==> " + cvalue);
//        System.out.println("page ==> " + page);
        Map map = new HashMap();

       PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"), category, cvalue);
       ArrayList<NoticeDto> slist = noticeService.getSearch(pageDto.getStartCount(), pageDto.getEndCount(), category, cvalue, pageDto.getPage());

        ArrayList<NoticeDto> result = noticeService.getList(category, cvalue, pageDto.getPage());

        map.put("page", pageDto);
        map.put("slist", slist);
        System.out.println(pageDto);
        System.out.println(slist);
//        System.out.println(result);
//       System.out.println(map);

        return map;
    }

    @GetMapping("admin_reservationlist_json_data/{page}/")
    public Map admin_reservationlist_json_data(@PathVariable String page){
        System.out.println("page-->"+page);
        Map map = new HashMap();
        PageDto pageDto = pageService.getPageResult(new PageDto(page,"adminReserv"));
        List<OrderDto> list = orderService.list(pageDto);

        map.put("list", list);
        map.put("page", pageDto);

        return map;
    }


}