package com.project01.mk01.service;

import com.project01.mk01.dto.LoginBoardDto;

public interface LoginBoardService {

    public LoginBoardDto searchBoard(LoginBoardDto loginBoardDto);

    public int signup(LoginBoardDto loginBoardDto);

    public int idCheck(LoginBoardDto loginBoardDto);

    public int nickNameCheck(LoginBoardDto loginBoardDto);
}
