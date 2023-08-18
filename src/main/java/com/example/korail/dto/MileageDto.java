package com.example.korail.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageDto {
    // Date를 String으로 저장 시, 시간까지 표기되지만 왜 LocalDate로 하면 생략되는걸까
    String mid;
    String id;
    LocalDate accumulationDate;
    int changeAmount;
    String specifics;
    LocalDate expirationDate;
    String depplandTime;
    int type;

    int accumulatedAmount;
    int rno;

    String use_mileage;
}
