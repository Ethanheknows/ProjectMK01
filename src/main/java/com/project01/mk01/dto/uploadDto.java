package com.project01.mk01.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class uploadDto {

    int no;

    private MultipartFile file; // insert.html에 file의 name

    String userId;

    String original;

    private String renamed;

    private String originalPath;

}
