package com.project01.mk01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project01.mk01.dao.LoginBoardDao;
import com.project01.mk01.dto.LoginBoardDto;

import groovy.util.logging.Slf4j;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LoginBoardServiceImpl implements LoginBoardService {
    @Autowired
    LoginBoardDao loginBoardDao;

    public LoginBoardDto searchBoard(LoginBoardDto loginBoardDto) {
        log.info(loginBoardDto);
        LoginBoardDto result = loginBoardDao.searchBoard(loginBoardDto);

        return result;
    }

}
