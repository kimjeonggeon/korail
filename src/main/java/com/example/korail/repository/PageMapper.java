package com.example.korail.repository;

import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PageMapper {
    int totalRowCount(PageDto pageDto);
    int totalRowCount2(String id);
    int totalRowCount(String category, String cvalue);
}
