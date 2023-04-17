package com.project01.mk01.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class commentBoardDto {

    private int no;
    private String contents;
    private String regDate;
    private int imageNum; // insert.html에 file의 name
    private int available;
    private String nickName;
    private String original;

}
