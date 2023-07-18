package com.example.korail.controller;

import com.example.korail.dto.CardinfoDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.dto.UpdateDto;
import com.example.korail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;

@Controller
public class ReservationlistController {
    @Autowired
    OrderService orderService;


    @GetMapping("reservation_main")
    public String reservation_main(OrderDto orderDto, HttpSession session, Model model){
        SessionDto svo = (SessionDto)session.getAttribute("svo");
        /*System.out.println("cardnum3 -> "+svo.getCardnum());
        System.out.println("email3 -> "+svo.getEmail());*/
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
        /*System.out.println("cardnum4-->"+orderDto.getCardnum());
        System.out.println("id-->"+orderDto.getId());
        System.out.println("email4-->"+orderDto.getEmail());*/

        ArrayList<OrderDto> orderList = orderService.getSelect(orderDto);
        /*System.out.println("orderList-->"+ orderList);*/
        if(orderList != null){
            model.addAttribute("orderList",orderList);
            orderReturn = "reservationlist/reservation_main";
        }

        return orderReturn;
    }

    @PostMapping("cardnum_check")
    public String cardnum_check_proc(String cardnum, String userId, String email, HttpSession session,Model model){
       /* System.out.println("cardnum1-->"+cardnum);
        System.out.println("email1-->"+email);*/

        int result = orderService.getCardnum(cardnum,email);
        /*System.out.println("result-->"+result);*/

        String orderReturn = null;
        if(result != 0){
            SessionDto svo = new SessionDto();
            svo.setId(userId);
            svo.setCardnum(cardnum);
            svo.setEmail(email);
           /* System.out.println("cardnum2-->"+svo.getCardnum());
            System.out.println("email2-->"+svo.getEmail());*/
            session.setAttribute("svo",svo);

            orderReturn = "redirect:/reservation_main";
        }else {
            orderReturn = "reservationlist/login_fail";
        }
        return orderReturn;
    }


    @GetMapping("reservation_receipt/{reservnum}")
    public String reservation_receipt(@PathVariable String reservnum, Model model) {

        OrderDto orderDto = orderService.getSelected(reservnum);

        model.addAttribute("odt", orderDto);
        return "reservationlist/reservation_receipt";
    }

    @GetMapping("reservation_hometicket/{reservnum}")
    public String reservation_hometicket(@PathVariable String reservnum, Model model) {

        OrderDto orderDto = orderService.getSelected(reservnum);

        model.addAttribute("odt", orderDto);
        return "reservationlist/reservation_hometicket";
    }

    /* update1 */
    @GetMapping("reservation_update/{reservnum}")
    public String reservation_update(HttpSession session, @PathVariable String reservnum, Model model) {
        OrderDto orderDto = orderService.getSelected(reservnum);

        UpdateDto uvo = new UpdateDto();
        uvo.setReservnum(reservnum);

        model.addAttribute("odt", orderDto);
        session.setAttribute("uvo", uvo);

        return "/reservationlist/reservation_update";


    }

    /* update2 */
    @GetMapping("reservation_updatetime/{traintime}/{depPlaceId}/{arrPlaceId}")
    public String reservation_updatetime(HttpSession session, @PathVariable String traintime, @PathVariable String depPlaceId, @PathVariable String arrPlaceId ) {

        UpdateDto uvo = (UpdateDto)session.getAttribute("uvo");

        uvo.setRtime(traintime);
        uvo.setStartId(depPlaceId);
        uvo.setEndId(arrPlaceId);

        return "/reservationlist/reservation_updatetime";
    }

    /* update3 */
    @PostMapping("reservation_updatechair")
    public String reservation_updatechair(UpdateDto uvo, HttpSession session, String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {

        //System.out.println(depplacename);
        uvo = (UpdateDto)session.getAttribute("uvo");

        uvo.setDepplacename(depplacename);
        uvo.setArrplacename(arrplacename);
        uvo.setStart_date(start_date);
        uvo.setEnd_date(end_date);
        uvo.setTraingradename(traingradename);
        uvo.setTrainno(trainno);
        uvo.setAdultcharge(adultcharge);
        uvo.setRtimes(rtimes);


        return "/reservationlist/reservation_updatechair";

    }

    /* update 3.5 */
    @GetMapping("reservation_updateselect/{seatNum}/{ticketQty}/{id}/{adltTotAmt}")
    public String reservation_updateselect(@PathVariable String seatNum, @PathVariable String ticketQty, @PathVariable String id , @PathVariable String adltTotAmt, HttpSession session) {

        /*System.out.println("seatNum-->"+seatNum);
        System.out.println("ticketQty-->"+ticketQty);
        System.out.println("adltTotAmt-->"+adltTotAmt);
        System.out.println("id-->"+id);*/

        UpdateDto uvo = (UpdateDto)session.getAttribute("uvo");

        uvo.setSeatNum(seatNum);
        uvo.setTicketQty(ticketQty);
        uvo.setId(id);
        uvo.setAdltTotAmt(adltTotAmt);
        //"redirect:/train_reservation_stplcfmpym1.do"
        return "/reservationlist/reservation_updatepay";
    }

    /* update 4 */
    @GetMapping("reservation_updatepay")
    public String reservation_updatepay(UpdateDto uvo, HttpSession session) {
        //model.addObject("seatNum", reservationVo.getSeatNum() );
        return "/reservationlist/reservation_updatepay";
    }

    /* update 5 - last */
    @PostMapping("reservation_updatepay")
    public String reservation_updatepay_proc(HttpSession session, OrderDto orderDto, CardinfoDto cardinfoDto) {
        String resultPay = "";
        UpdateDto uvo = (UpdateDto) session.getAttribute("uvo");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        int number = Integer.parseInt(uvo.getAdltTotAmt());
        String price = decimalFormat.format(number);

        orderDto.setReservnum(uvo.getReservnum());
        orderDto.setSstation(uvo.getDepplacename());
        orderDto.setStime(uvo.getStart_date());
        orderDto.setDtime(uvo.getEnd_date());
        orderDto.setDstation(uvo.getArrplacename());
        orderDto.setChairnum(uvo.getSeatNum());
        orderDto.setId(uvo.getId());
        orderDto.setDepPlaceId(uvo.getStartId());
        orderDto.setArrPlaceId(uvo.getEndId());
        orderDto.setDepPlandTime(uvo.getRtimes());
        orderDto.setCardnum(cardinfoDto.getCardnum());
        orderDto.setPrice(price);
        orderDto.setTrainnum(Integer.parseInt(uvo.getTrainno()));
        orderDto.setTicketqty(Integer.parseInt(uvo.getTicketQty()));


        int result = orderService.getPaymentUpdate(orderDto);

        if(result == 1) {
            resultPay = "redirect:/reservation_main";
        }else {
            //에러페이지
        }
        return resultPay;
    }




    /* admin_main */
    @GetMapping("admin_main")
    public String admin_main() {

        return "/admin/admin_main";
    }

    /* admin - trainTime*/
    @GetMapping("admin_trainlist")
    public String admin_trainlist() {

        return "/admin/admin_trainlist";
    }


}//controller
