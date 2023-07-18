package com.example.korail.service;

import com.example.korail.dto.MemberaddDto;
import com.example.korail.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    public Object fileCheck(NoticeDto noticeDto) {
        if(noticeDto.getFile1().getOriginalFilename() != null && !noticeDto.getFile1().getOriginalFilename().equals("")) {

            // NSFILE 중복 처리
            UUID uuid = UUID.randomUUID();
            String nfile = noticeDto.getFile1().getOriginalFilename();
            String nsfile = uuid + "_" + nfile;
            noticeDto.setNfile(nfile);
            noticeDto.setNsfile(nsfile);
        } else {
            System.out.println("파일 없음");
        }
            return noticeDto;
    }

    public Object fileCheck(MemberaddDto memberaddDto) {
        if(memberaddDto.getFile1().getOriginalFilename() != null && !memberaddDto.getFile1().getOriginalFilename().equals("")) {

            // NSFILE 중복 처리
            UUID uuid = UUID.randomUUID();
            String afile = memberaddDto.getFile1().getOriginalFilename();
            String asfile = uuid + "_" + afile;
            memberaddDto.setAfile(afile);
            memberaddDto.setAsfile(asfile);
        } else {
            System.out.println("파일 없음");
        }
        return memberaddDto;
    }

    public void fileSave(MemberaddDto memberaddDto) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";

        if(memberaddDto.getFile1().getOriginalFilename() != null && !memberaddDto.getFile1().getOriginalFilename().equals("")) {
            File saveFile = new File(projectPath + memberaddDto.getAsfile());
            memberaddDto.getFile1().transferTo(saveFile);
        }
    }

    public void fileSave(NoticeDto noticeDto) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
        System.out.println("path===>>>" + projectPath);

        if(noticeDto.getFile1().getOriginalFilename() != null && !noticeDto.getFile1().getOriginalFilename().equals("")) {
            File saveFile = new File(projectPath + noticeDto.getNsfile());
            noticeDto.getFile1().transferTo(saveFile);
        }
    }

    public void fileDelete(String oldNsFile) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
        File deleteFile = new File(projectPath + oldNsFile);
        if(deleteFile.exists()) {
            deleteFile.delete();
        }
    }
}
