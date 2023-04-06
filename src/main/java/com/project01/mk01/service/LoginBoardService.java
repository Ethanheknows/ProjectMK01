package com.project01.mk01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project01.mk01.dao.LoginBoardDao;
import com.project01.mk01.dto.LoginBoardDto;

import lombok.extern.slf4j.Slf4j;

public interface LoginBoardService {

    public LoginBoardDto searchBoard(LoginBoardDto loginBoardDto);

}
