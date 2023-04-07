package com.project01.mk01.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginBoardDto {

    private int no;

    private String nickName;

    private String userId;

    private String userPw;

    private String userPwCheck;

    // @NotBlank(message = "이메일을 확인 해주세요.")
    private String userEmail;
}
