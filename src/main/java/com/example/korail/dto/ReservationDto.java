package com.example.korail.dto;

import lombok.Data;

@Data
public class ReservationDto {
    private String ticketQty1,ticketQty2,ticketQty,seatNum,startId,endId,start_add,end_add,rtime,depplacename, arrplacename,start_date,end_date,traingradename,trainno,adultcharge,rtimes,seatNum1,seatNum2;
    private String division,id,trnumber,email,email1, email2;

    public String getEmail() {
        if(email1 != null) {
            email = email1 +"@" + email2;
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
