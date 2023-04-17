package com.project01.mk01.service;

import java.util.List;
import java.util.Map;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.commentBoardDto;

public interface ImageService {
    public int insertGallery(ImageDto imageDto);

    public List<ImageDto> getAllimages();

    public List<commentBoardDto> getAllcomment();
}
