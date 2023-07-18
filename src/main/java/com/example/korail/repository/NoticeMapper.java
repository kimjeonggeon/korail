package com.example.korail.repository;

import com.example.korail.dto.NoticeDto;
import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

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
}
