package com.example.korail.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NoticeDto {
	int rno, nhits;
	String nid, ntitle, ncontent, ndate, page, category, cvalue, nfile, nsfile;
	MultipartFile file1;
}