package com.example.korail.dto;

import lombok.Data;

@Data
public class PageDto {
    private final String category;
    private final String cvalue;
    private final String page;
    private final String serviceName;
    private int startCount;
    private int endCount;
    private int dbCount;
    private int pageSize;
    private int pageCount;
    private int reqPage;
    private NoticeDto noticeDto;

}
