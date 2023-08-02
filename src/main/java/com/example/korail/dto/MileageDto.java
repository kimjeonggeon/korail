package com.example.korail.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageDto {

    String mid;
    String id;
    String accumulationDate;
    int changeAmount;
    String specifics;
    LocalDate expirationDate;
    int type;

    int accumulatedAmount;
    int rno;
}
