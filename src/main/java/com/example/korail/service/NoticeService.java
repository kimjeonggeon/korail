package com.example.korail.service;

import com.example.korail.dto.NoticeDto;
import com.example.korail.dto.PageDto;
import com.example.korail.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public int insert(NoticeDto noticeDto) {
        return noticeMapper.insert(noticeDto);
    }

    public int update(NoticeDto noticeDto) {
        return noticeMapper.update(noticeDto);
    }

    public String getNsfile(String nid) {
        return noticeMapper.getNsfile(nid);
    }

    public int delete(String nid) {
        return noticeMapper.delete(nid);
    }

    public void updateHits(String nid) {
        noticeMapper.updateHits(nid);
    }

    public ArrayList<NoticeDto> getNid(String nid) {
        return noticeMapper.getNid(nid);
    }

    public ArrayList<NoticeDto> getSearch(int startCount, int endCount, String category, String cvalue) {
        return noticeMapper.getSearch(startCount, endCount, category, cvalue);
    }
}
