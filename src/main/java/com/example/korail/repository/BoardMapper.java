package com.example.korail.repository;

import com.example.korail.dto.BoardDto;
import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int delete(String bid);
    int update(BoardDto boardDto);
    BoardDto boardupdate(String bid);
    BoardDto content(String bid);
    int registration(BoardDto boardDto);
    List<BoardDto> list(PageDto pageDto);
}
