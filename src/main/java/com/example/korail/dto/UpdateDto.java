package com.example.korail.dto;

import lombok.Data;

@Data
public class UpdateDto {
    String reservnum,ticketQty1,ticketQty2,ticketQty,seatNum,startId,endId,start_add,end_add,rtime,depplacename, arrplacename,start_date,end_date,traingradename,trainno,adultcharge,rtimes,seatNum1,seatNum2;
    String division,id,trnumber;
}
