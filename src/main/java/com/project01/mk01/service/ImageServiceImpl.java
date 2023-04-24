package com.project01.mk01.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.executor.loader.ResultLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project01.mk01.dao.ImageDao;
import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.commentBoardDto;
import com.project01.mk01.dto.uploadDto;

import groovyjarjarantlr4.v4.misc.EscapeSequenceParsing.Result;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    @Value("${file.path}")
    private String uploadFoler;

    @Override
    public int insertGallery(ImageDto imageDto) {

        String originalFile = imageDto.getFile().getOriginalFilename();
        Path imgFilePath = Paths.get(uploadFoler + originalFile);

        if (originalFile.contains(".gif")) {
            imgFilePath = Paths.get(uploadFoler + "gif/" + originalFile);

        } else {
            imgFilePath = Paths.get(uploadFoler + "jpg/" + originalFile);

        }

        log.info(imgFilePath);
        log.info(uploadFoler);

        imageDto.setOriginal(originalFile);

        try {
            Files.write(imgFilePath, imageDto.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = imageDao.insertGallery(imageDto);
        return result;
    }

    public List<ImageDto> getAllimages() {

        List<ImageDto> result = imageDao.getAllimages();
        return result;

    }

    public List<ImageDto> orderByHitImages() {

        List<ImageDto> result = imageDao.orderByHitImages();
        return result;

    }

    public List<uploadDto> getUploadOrignalPath() {

        List<uploadDto> result = imageDao.getUploadOrignalPath();
        return result;

    }

    public List<commentBoardDto> getAllcomment() {

        List<commentBoardDto> result = imageDao.getAllcomment();
        return result;

    }

    public int insertImage(uploadDto uploadDto) {

        UUID uuid = UUID.randomUUID();
        // form에서 전달된 파일이름
        String originalFile = uploadDto.getFile().getOriginalFilename() + ".jpg";
        // 중복방지용 이름
        String renamedFile = uuid + "_" + originalFile;

        Path imgFilePath = Paths.get(uploadFoler + "upload/" + renamedFile);

        uploadDto.setOriginal(originalFile);

        uploadDto.setRenamed(renamedFile);

        try {
            Files.write(imgFilePath, uploadDto.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(uploadDto);
        int result = imageDao.insertImage(uploadDto);

        return result;
    }

    @Override
    public int hitUp(ImageDto imagedto) {
        int result = imageDao.hitUp(imagedto);
        return result;
    }

}
