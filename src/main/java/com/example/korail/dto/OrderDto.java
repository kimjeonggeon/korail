package com.example.korail.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String sstation, rdate, stime, dtime, dstation, reservnum, chairnum, id, depPlaceId, arrPlaceId, depPlandTime, cardnum, cdate,email;
    private int rno, price, trainnum, ticketqty, cancel;
}
