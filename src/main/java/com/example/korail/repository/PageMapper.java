package com.example.korail.repository;

import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {

    int totalRowCount(PageDto pageDto);

    int totalRowCount(String category, String cvalue);

    int totalRowCount(PageDto pageDto, String category, String cvalue);
}