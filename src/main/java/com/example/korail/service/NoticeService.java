package com.example.korail.service;

import com.example.korail.dto.NoticeDto;
import com.example.korail.dto.PageDto;
import com.example.korail.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeDto> list(PageDto pageDto) {
        return noticeMapper.list(pageDto);
    }

    public NoticeDto content(String nid) {
        return noticeMapper.content(nid);
    }
}
