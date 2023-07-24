package com.example.korail.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NoticeDto {
	private int rno;
	private int nhits;
	private String nid;
	private String ntitle;
	private String ncontent;
	private String ndate;
	private String page;
	private String nfile;
	private String nsfile;
	private MultipartFile file1;	// 폼에서 넘어오는 파일 객체

}