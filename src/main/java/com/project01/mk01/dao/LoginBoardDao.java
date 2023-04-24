package com.project01.mk01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project01.mk01.dto.LoginBoardDto;
import com.project01.mk01.dto.uploadDto;

@Mapper
public interface LoginBoardDao {

    LoginBoardDto searchBoard(LoginBoardDto loginBoardDto);

    int signup(LoginBoardDto loginBoardDto);

    int idCheck(LoginBoardDto loginBoardDto);

    int nickNameCheck(LoginBoardDto loginBoardDto);

    int updateBoard(LoginBoardDto loginBoardDto);

    int deleteAccount(LoginBoardDto loginBoardDto);

    List<uploadDto> getAllupload();
}
