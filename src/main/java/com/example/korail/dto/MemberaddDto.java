package com.example.korail.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberaddDto {
    String aid;
    String afile;
    String asfile;
    int permission;
    int preferential;
    MultipartFile file1;
}