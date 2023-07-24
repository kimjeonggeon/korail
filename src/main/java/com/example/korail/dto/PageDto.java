package com.example.korail.dto;

import lombok.Data;

@Data
public class PageDto {
    private String page;
    private String serviceName;
    private int startCount;
    private int endCount;
    private int dbCount;
    private int pageSize;
    private int pageCount;
    private int reqPage;
    private String category;
    private String cvalue;


    public PageDto(String page, String serviceName) {
        this.page = page;
        this.serviceName = serviceName;
    }

    public PageDto(String page, String serviceName, String category, String cvalue) {
        this.page = page;
        this.serviceName = serviceName;
        this.category = category;
        this.cvalue = cvalue;
    }
}
