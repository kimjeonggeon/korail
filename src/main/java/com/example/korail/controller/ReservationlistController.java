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
    public String reservation_updatechair(UpdateDto uvo, HttpSession session,
                                          String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {

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
    @GetMapping("reservation_updateselect/{seatNum}/{ticketQty}/{id}")
    public String reservation_updateselect(@PathVariable String seatNum, @PathVariable String ticketQty, @PathVariable String id ,HttpSession session) {

        System.out.println("seatNum-->"+seatNum);
        System.out.println("ticketQty-->"+ticketQty);
        System.out.println("id-->"+id);

        UpdateDto uvo = (UpdateDto)session.getAttribute("uvo");

        uvo.setSeatNum(seatNum);
        uvo.setTicketQty(ticketQty);
        uvo.setId(id);
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
        String viewName="";
        UpdateDto uvo = (UpdateDto) session.getAttribute("uvo");

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
        orderDto.setPrice(Integer.parseInt(uvo.getAdultcharge()));
        orderDto.setTrainnum(Integer.parseInt(uvo.getTrainno()));
        orderDto.setTicketqty(Integer.parseInt(uvo.getTicketQty()));


        /*int result = orderService.getPaymentUpdate(orderDto);*/
        //cardService.getPaymentUpdate(cardVo);
        /*if(result == 1) {
            viewName = "redirect:/reservation_main.do";
        }else {
            //에러페이지
        }*/
        return viewName;
    }



}//controller
