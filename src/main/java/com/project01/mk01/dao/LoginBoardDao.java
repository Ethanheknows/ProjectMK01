package com.project01.mk01.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project01.mk01.dto.LoginBoardDto;

@Mapper
public interface LoginBoardDao {

    LoginBoardDto searchBoard(LoginBoardDto loginBoardDto);

    int signup(LoginBoardDto loginBoardDto);

    int idCheck(LoginBoardDto loginBoardDto);

    int nickNameCheck(LoginBoardDto loginBoardDto);
}
