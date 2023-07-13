package com.example.korail.service;

import com.example.korail.dto.PageDto;
import com.example.korail.repository.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PageService {
    @Autowired
    PageMapper pageMapper;

    public PageDto getPageResult4(PageDto pageDto, String category, String cvalue){


        String pageReturn = null;

        //페이징 처리 - startCount, endCount 구하기
        int startCount = 0;
        int endCount = 0;
        int pageSize = 0;	//한페이지당 게시물 수
        int reqPage = 1;	//요청페이지
        int pageCount = 1;	//전체 페이지 수
        int dbCount = 0;	//DB에서 가져온 전체 행수

        System.out.println("pageDto -->"+ pageDto);

        if (pageDto.getServiceName().equals("notice")) {
            dbCount = pageMapper.totalRowCount(category, cvalue);
            pageSize = 3;
        } else if (pageDto.getServiceName().equals("member")) {
            dbCount = pageMapper.totalRowCount(pageDto, category, cvalue);
            pageSize = 5;
        } else if (pageDto.getServiceName().equals("adminReserv")) {
            dbCount = pageMapper.totalRowCount(pageDto, category, cvalue);
            pageSize = 5;
        }

        //총 페이지 수 계산
        if (dbCount % pageSize == 0) {
            pageCount = dbCount / pageSize;
        } else {
            pageCount = (int) Math.ceil((double) dbCount / pageSize);
        }

// 요청 페이지 계산
        if (pageDto != null && pageDto.getPage() != null) {
            reqPage = Integer.parseInt(pageDto.getPage());
            startCount = (reqPage - 1) * pageSize + 1;
            endCount = reqPage * pageSize;
        } else {
            startCount = 1;
            endCount = pageSize;
        }

        //param 객체에  데이터 put
        pageDto.setStartCount(startCount);
        pageDto.setEndCount(endCount);
        pageDto.setDbCount(dbCount);
        pageDto.setPageSize(pageSize);
        pageDto.setPageCount(pageCount);
        pageDto.setReqPage(reqPage);


        return pageDto;
    }

    public PageDto getPageResult2(PageDto pageDto){

        int startCount = 0;
        int endCount = 0;
        int pageSize = 0;	//한페이지당 게시물 수
        int reqPage = 1;	//요청페이지
        int pageCount = 1;	//전체 페이지 수
        int dbCount = 0;	//DB에서 가져온 전체 행수

        dbCount = pageMapper.totalRowCount(pageDto);

        if(pageDto.getServiceName().equals("notice")) {
            pageSize = 3;
        }else if(pageDto.getServiceName().equals("member")) {
            pageSize = 5;
        }else if(pageDto.getServiceName().equals("adminReserv")) {
            pageSize = 5;
        }

        //총 페이지 수 계산
        if(dbCount % pageSize == 0){
            pageCount = dbCount/pageSize;
        }else{
            pageCount = dbCount/pageSize+1;
        }

        //요청 페이지 계산
        if(pageDto.getPage() != null){
            reqPage = Integer.parseInt(pageDto.getPage());
            startCount = (reqPage-1) * pageSize+1;
            endCount = reqPage *pageSize;
        }else{
            startCount = 1;
            endCount = pageSize;
        }

        //param 객체에  데이터 put
        pageDto.setStartCount(startCount);
        pageDto.setEndCount(endCount);
        pageDto.setDbCount(dbCount);
        pageDto.setPageSize(pageSize);
        pageDto.setPageCount(pageCount);
        pageDto.setReqPage(reqPage);

        return pageDto;
    }
}