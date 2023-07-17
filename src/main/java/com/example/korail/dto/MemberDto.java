package com.example.korail.dto;

import lombok.Data;

@Data
public class MemberDto {
    String id, pass, name, userEmail1, userEmail2, tel, phonenumber1, phonenumber2, phonenumber3 , year , month, date,
            gender;
    int rno, preferential;
    String mid, email , pnumber, birth , mdate,pagename,seatNum,ticketQty;

    public String getEmail() {
        if(userEmail1 != null) {
            email = userEmail1 +"@" + userEmail2;
        }
        return email;
    }

    public String getPnumber() {
        if(phonenumber1 != null) {
            pnumber = phonenumber1 + phonenumber2 + phonenumber3;
        }
        return pnumber;
    }
}
