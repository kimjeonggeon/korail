package com.example.korail.dto;

import lombok.Data;

@Data
public class MileageDto {

    String mid;
    String id;
    String accumulationDate;
    int changeAmount;
    String specifics;
    String expirationDate;
    int type;

    int rno;
}
