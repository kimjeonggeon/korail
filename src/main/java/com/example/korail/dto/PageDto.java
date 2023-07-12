package com.example.korail.dto;

import lombok.Data;

@Data
public class PageDto {

    public String getServiceName;
    private int startCount;
    private int endCount;
    private int dbCount;
    private int pageSize;
    private int reqPage;
    private int pageCount;
    private final String page; //final이 붙이면 생성자로 사용할수있다
    private final String serviceName; // final이 붙이면 생성자로 사용할수있다

}
