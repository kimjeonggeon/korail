package com.example.korail.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.MypageService;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MypageController {

    @Autowired
    private MypageService mypageService;

    @Autowired
    PmyhisService pmyhisService;

    @GetMapping("mypage")
    public String my_page(HttpSession session, Model model) {

        // Session 확인 후 'null'의 경우 로그인 페이지로 이동
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        if (svo == null) {
            return "redirect:/mylogin";
        }

        // Session의 id로 유저 정보를 변수로 생성
        List<MemberDto> getUserinfo = mypageService.getInfo(svo.getId());

        // 위 변수를 id, pass, phoneNumber를 변수로 세분화, 이는 mypage에서 사용된다.
        String memberId = getUserinfo.get(0).getId();
        String memberPass = getUserinfo.get(0).getPass();
        String memberPnumber = getUserinfo.get(0).getPnumber();
        // mypage head의 '나의 예매내역' 건수를 나타내는 변수
        int countNum = mypageService.getCount(memberId);

        // 해당 페이지에 session으로 생성한 변수 할당
        session.setAttribute("countNum", countNum);
        session.setAttribute("memberId", memberId);
        session.setAttribute("memberPass", memberPass);
        session.setAttribute("memberPnumber", memberPnumber);


        String id = svo.getId();
        int mileage = pmyhisService.mileage(id);
        model.addAttribute("mileage", mileage);

        return "my_page/my_page";
    }

    @GetMapping("/mylogin")
    public String reservation_login() {

        return "my_page/loginm";
    }

    @GetMapping("/mypage_modal")
    public String my_page_modal() {

        return "my_page/mypage_modal";
    }

    @PostMapping("/mypage_Phoneproc")
    public String mypage_Phoneproc(HttpSession session, String usrPw4, String usrPw5, Model model) {

        // usrPw4는 현재 비밀번호와 비교, usrPw5는 새롭게 바뀔 비밀번호

        // Session 정보 수집
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        
        // 비밀번호 변경을 위한 Id와 Password 데이터 전달 객체
        HashMap<String, String> param = new HashMap<String, String>();

        // 현재 로그인한 유저의 Id와 Password를 변수로 생성
        List<MemberDto> getUserinfo = mypageService.getInfo(svo.getId());
        String memberId = getUserinfo.get(0).getId();
        String pass = getUserinfo.get(0).getPass();

        // modal창의 입력란에 현재 비밀번호 입력이 정확한 경우
        if (usrPw4.equals(pass)) {

            // Mybatis로 WHERE절에 들어갈 데이터 전송
            param.put("memberId", memberId);
            param.put("pnumber", usrPw5);

            // 비밀번호 업데이트 성공 시 result = 1
            int result = mypageService.getPnumberUpdate(param);
            if (result == 1) {
                // mypage의 Script로 alert창 생성 및 새로운 url로 이동을 위한 model 전달
                model.addAttribute("c_pnum", "ok");
            }
        }

        return "my_page/my_page";
    }

    @PostMapping("/mypage_wtihProc")
    public String mypage_wtihProc(HttpSession session) {
        // Session 정보 수집
        SessionDto svo = (SessionDto) session.getAttribute("svo");

        // 탈퇴 시, session의 id로 Mybatis를 활용해 탈퇴 진행
        int result = mypageService.getWithresult(svo.getId());
        if (result == 1) {
            session.invalidate();
        }
        return "index";
    }

    @PostMapping("/mypage_cpassProc")
    public String my_page_cpass(HttpSession session, String usrPw1, String usrPw2, Model model) {
        
        // Session 데이터 수집
        SessionDto svo = (SessionDto) session.getAttribute("svo");

        // 비밀번호 변경을 위해 회원 Id, 현재 비밀번호 그리고 수정할 비밀번호를 HashMap으로 생성하여 이를 전달한다.
        HashMap<String, String> param = new HashMap<String, String>();

        param.put("memberId", svo.getId());
        param.put("nPass", usrPw1);
        param.put("cPass", usrPw2);
        
        // HashMap으로 비밀번호 변경 업데이트의 매개변수 전달
        int result = mypageService.getPassupdate(param);
        if (result == 1) {
            // 이후 비밀번호 변경 성공 시, myapgealert창과 함께 mypage로 이동하는 url 생성
            model.addAttribute("c_pass", "ok");
        }

        return "/my_page/my_page";
    }

    @GetMapping("mileage")
    public String mypage_modal() {
        return "/my_page/mileage_modal";
    }
}