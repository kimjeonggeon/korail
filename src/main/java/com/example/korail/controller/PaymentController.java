package com.example.korail.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.example.korail.dto.MemberaddDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.FileService;
import com.example.korail.service.MypageService;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    PmyhisService pmyhisService;

    @Autowired
    FileService fileService;

    @Autowired
    MypageService mypageService;

    @GetMapping("/pmyhis")
    // 결제내역 조회 메인 페이지
    public String pmyhis() {

        return "/payment_history/payment_history_view";
    }


    @GetMapping("/paycal")
    // 달력 호출
    public String paycal() {

        return "/payment_history/calender";
    }

    @GetMapping("/paypment_json_data/{date1Str}/{date2Str}/{checked}")
    //승차권 조회
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
    // 맞춤형 우대 예약 사이트
    public String simple_purchased() {
        return "/payment_history/s_reservation";
    }

    @PostMapping("/preferential_proc")
    // 맞춤형 우대 예약 신청 과정
    public String preferential_proc (HttpSession session ,MemberaddDto memberadddto) throws Exception {
        //ADDINFO 테이블에 데이터 전송 객체 생성
        HashMap<String, String> param = new HashMap<>();

        // 해당 객체에 aid와 우대 value 추가 1.경로 2.장애 3.유공
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        String aid = svo.getAid();

        param.put("aid", aid);
        param.put("preferential", String.valueOf(memberadddto.getPreferential()));

        pmyhisService.preferential(param);
        
        // 전 파일(oldAsfile) 존재 시, 해당 데이터 삭제 및 신규 데이터로 변경
        String oldAsfile = pmyhisService.oldfile(aid);
        memberadddto = (MemberaddDto) fileService.fileCheck(memberadddto);
        memberadddto.setAid(aid);
        int result = mypageService.update(memberadddto);
        if(result == 1) {
            fileService.fileSave(memberadddto);
            fileService.fileDelete(oldAsfile);
        }

        return "index";
    }
}