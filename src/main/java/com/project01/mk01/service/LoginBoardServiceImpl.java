package com.project01.mk01.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project01.mk01.dao.LoginBoardDao;
import com.project01.mk01.dto.LoginBoardDto;

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

    public int signup(LoginBoardDto loginBoardDto) {
        // UUID uuid = UUID.randomUUID();
        // String originalFile = loginBoardDto.getOriginalFile().getOriginalFilename();

        // String renameFile = uuid + "_" + originalFile;
        // log.info(originalFile);
        // log.info(renameFile);

        // Path imgFilePath = Paths.get(uploadFolder + renameFile);
        // log.info(imgFilePath.toString());

        // loginBoardDto.setOriginalFilePath(originalFile);// 파일이름 dto에입력
        // loginBoardDto.setRenameFilePath(renameFile);// 파일경로 dto에입력

        // try {
        // Files.write(imgFilePath, loginBoardDto.getOriginalFile().getBytes());
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        int result = loginBoardDao.signup(loginBoardDto);
        return result;
    }

    @Override
    public int idCheck(LoginBoardDto loginBoardDto) {
        // TODO Auto-generated method stub

        int result = loginBoardDao.idCheck(loginBoardDto);
        return result;
    }

    public int nickNameCheck(LoginBoardDto loginBoardDto) {
        // TODO Auto-generated method stub

        int result = loginBoardDao.nickNameCheck(loginBoardDto);
        return result;
    }

}
