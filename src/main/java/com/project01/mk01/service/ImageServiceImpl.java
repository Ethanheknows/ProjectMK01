package com.project01.mk01.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project01.mk01.dao.ImageDao;
import com.project01.mk01.dto.ImageDto;

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

        // form에서 전달된 파일이름
        String originalFile = imageDto.getFile().getOriginalFilename();
        // 중복방지용 이름

        Path imgFilePath = Paths.get(uploadFoler + originalFile);

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

}
