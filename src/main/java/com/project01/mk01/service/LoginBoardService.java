package com.project01.mk01.service;

import java.util.List;

import com.project01.mk01.dto.LoginBoardDto;
import com.project01.mk01.dto.uploadDto;

public interface LoginBoardService {

    public LoginBoardDto searchBoard(LoginBoardDto loginBoardDto);

    public int signup(LoginBoardDto loginBoardDto);

    public int idCheck(LoginBoardDto loginBoardDto);

    public int nickNameCheck(LoginBoardDto loginBoardDto);

    public int updateBoard(LoginBoardDto loginBoardDto);

    public int deleteAccount(LoginBoardDto loginBoardDto);

    public List<uploadDto> getAllupload();

}
