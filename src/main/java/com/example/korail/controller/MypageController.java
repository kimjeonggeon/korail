package com.example.korail.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.interceptor.BCrypt;
import com.example.korail.service.MileageService;
import com.example.korail.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MypageController {

    @Autowired
    MypageService mypageService;

    @Autowired
    MileageService mileageService;

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
        String memberPnumber = getUserinfo.get(0).getPnumber();
        // mypage head의 '나의 예매내역' 건수를 나타내는 변수
        int countNum = mypageService.getCount(memberId);

        // 해당 페이지에 session으로 생성한 변수 할당
        session.setAttribute("countNum", countNum);
        session.setAttribute("memberId", memberId);

        session.setAttribute("memberPnumber", memberPnumber);

        int mileage = mileageService.getMileage(memberId);

        model.addAttribute("mileage", mileage);

        return "my_page/my_page";
    }

    @GetMapping("mypage_{detail}")
    public String my_page_with(HttpSession session, Model model, @PathVariable("detail") String detail) {

        if(detail.equals("pass")) {
            model.addAttribute("detail", "pass");
        } else if (detail.equals("phone")) {
            model.addAttribute("detail", "phone");
        } else if (detail.equals("with")) {
            model.addAttribute("detail", "with");
        }

        // Session 확인 후 'null'의 경우 로그인 페이지로 이동
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        if (svo == null) {
            return "redirect:/mylogin";
        }

        // Session의 id로 유저 정보를 변수로 생성
        List<MemberDto> getUserinfo = mypageService.getInfo(svo.getId());

        // 위 변수를 id, pass, phoneNumber를 변수로 세분화, 이는 mypage에서 사용된다.
        String memberId = getUserinfo.get(0).getId();
        String memberPnumber = getUserinfo.get(0).getPnumber();
        // mypage head의 '나의 예매내역' 건수를 나타내는 변수
        int countNum = mypageService.getCount(memberId);

        // 해당 페이지에 session으로 생성한 변수 할당
        session.setAttribute("countNum", countNum);
        session.setAttribute("memberId", memberId);

        session.setAttribute("memberPnumber", memberPnumber);

        int mileage = mileageService.getMileage(memberId);

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

        // modal창의 입력란에 현재 비밀번호 입력이 정확한 경우
        if (BCrypt.checkpw(usrPw4, svo.getPass())) {


            // Mybatis로 WHERE절에 들어갈 데이터 전송
            param.put("memberId", memberId);
            param.put("pnumber", usrPw5);

            // 비밀번호 업데이트 성공 시 result = 1
            int result = mypageService.getPnumberUpdate(param);
            if (result == 1) {
                // mypage의 Script로 alert창 생성 및 새로운 url로 이동을 위한 model 전달
                model.addAttribute("c_pnum", "ok");
            }
        } else {
            model.addAttribute("c_pnum", "noop");
        }


        return "my_page/my_page";
    }

    @PostMapping("/mypage_withProc")
        public String mypage_withProc(HttpSession session, String userpass, Model model) {
        String withProcValue = "";
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        if (BCrypt.checkpw(userpass, svo.getPass())) {
            // 탈퇴 시, session의 id로 Mybatis를 활용해 탈퇴 진행
            int result = mypageService.getWithresult(svo.getId());
            if (result == 1) {
                withProcValue = "ok";
                session.invalidate();
            }
        } else {
            model.addAttribute("withProc", "no");
            return "my_page/my_page";
        }
        model.addAttribute("withProc", withProcValue);
        return "index";
    }

    @PostMapping("/mypage_cpassProc")
    public String my_page_cpass(HttpSession session, String usrPw1, String usrPw2, String usrPw3, Model model) {

        // Session 데이터 수집
        SessionDto svo = (SessionDto) session.getAttribute("svo");

        // 비밀번호 변경을 위해 회원 Id, 현재 비밀번호 그리고 수정할 비밀번호를 HashMap으로 생성하여 이를 전달한다.
        HashMap<String, String> param = new HashMap<String, String>();

        param.put("memberId", svo.getId());
        param.put("nPass", svo.getPass());
        param.put("cPass", BCrypt.hashpw(usrPw2, BCrypt.gensalt(10)));

        if(usrPw1.length() == 0) {
            model.addAttribute("c_pass", "nothing");
        } else if (usrPw1.length() < 8) {
            model.addAttribute("c_pass", "short");
        } else if (!BCrypt.checkpw(usrPw1, svo.getPass())) {
            model.addAttribute("c_pass", "noop");
        } else if(usrPw2.equals("") || usrPw3.equals("")) {
            model.addAttribute("c_pass", "blank");
        } else if (!usrPw2.equals(usrPw3)) {
            model.addAttribute("c_pass", "notsame");
        } else if (!(usrPw2.length() >= 8 && containsBothLettersAndDigits(usrPw1))) {
            model.addAttribute("c_pass", "wrong");
        } else {
            // HashMap으로 비밀번호 변경 업데이트의 매개변수 전달
            if (BCrypt.checkpw(usrPw1, svo.getPass())) {
                int result = mypageService.getPassupdate(param);
                if (result == 1) {
                    session.invalidate();
                    model.addAttribute("passC_result", "done");
                    return "index";
                }
            } else {
                model.addAttribute("c_pass", "noop");
                System.out.println(55555);
            }
        }

        return "/my_page/my_page";
    }

    private boolean containsBothLettersAndDigits(String input) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasLetter && hasDigit) {
                return true; // 영어와 숫자가 혼합된 조건 충족
            }
        }

        return false; // 조건 미충족
    }


    @GetMapping("mileage")
    public String mypage_modal(Model model) {
        return "/my_page/mileage_modal";
    }
}