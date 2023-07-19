package com.example.korail.repository;

import com.example.korail.dto.NoticeDto;
import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> list(PageDto pageDto);
    NoticeDto content(String nid);
    int insert(NoticeDto noticeDto);
    int update(NoticeDto noticeDto);
    String getNsfile(String nid);
    int delete(String nid);
    void updateHits(String nid);
    ArrayList<NoticeDto> getNid(String nid);
    ArrayList<NoticeDto> getSearch(int startCount, int endCount, String category, String cvalue);
    ArrayList<NoticeDto> getList(String category, String cvalue);
}
