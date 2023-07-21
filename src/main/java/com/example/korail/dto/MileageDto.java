package com.example.korail.dto;

import lombok.Data;

@Data
public class MileageDto {

    String mid;
    String id;
    String accumulationdate;
    String specifics;
    String expirationdate;

    int changeamout;
    int totalmileage;
}
