package com.example.korail.service;

import com.example.korail.dto.BoardDto;
import com.example.korail.dto.PageDto;
import com.example.korail.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDto> list(PageDto pageDto){
        return boardMapper.list(pageDto);
    }
}
