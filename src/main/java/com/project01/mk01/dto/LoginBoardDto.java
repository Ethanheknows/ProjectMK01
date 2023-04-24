package com.project01.mk01.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginBoardDto {

    private int no;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String nickName;

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String userPw;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String userPwCheck;

    // @NotBlank(message = "이메일을 확인 해주세요.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 양식을 지켜서 입력해 주세요.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String userEmail;

    private int existence;

}
