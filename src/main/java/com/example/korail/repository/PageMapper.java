package com.example.korail.repository;

import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {
    int totalRowCount(PageDto pageDto);
}
