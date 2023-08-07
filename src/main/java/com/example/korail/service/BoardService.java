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

    public int delete(String bid){
        System.out.println("서비스는 와지나?");
        return boardMapper.delete(bid);
    }
    public int update(BoardDto boardDto){

        return boardMapper.update(boardDto);
    }
    public BoardDto boardupdate(String bid){

        return boardMapper.boardupdate(bid);
    }
    public BoardDto content(String bid){

        return boardMapper.content(bid);
    }
    public int getRegistration(BoardDto boardDto){
        return boardMapper.registration(boardDto);
    }
    public List<BoardDto> list(PageDto pageDto){
        return boardMapper.list(pageDto);
    }
}
