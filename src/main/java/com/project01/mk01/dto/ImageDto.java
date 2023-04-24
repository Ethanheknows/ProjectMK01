package com.project01.mk01.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ImageDto {

    int no;
    private String title;
    private String tag;
    private MultipartFile file; // insert.html에 file의 name
    private String original;
    private String regDate;
    private int hit;

}
