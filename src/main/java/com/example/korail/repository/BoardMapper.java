package com.example.korail.repository;

import com.example.korail.dto.BoardDto;
import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> list(PageDto pageDto);
}
