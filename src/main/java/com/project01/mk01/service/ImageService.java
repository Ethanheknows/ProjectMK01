package com.project01.mk01.service;

import java.util.List;
import java.util.Map;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.commentBoardDto;
import com.project01.mk01.dto.uploadDto;

public interface ImageService {
    public int insertGallery(ImageDto imageDto);

    public List<ImageDto> getAllimages();

    public List<ImageDto> orderByHitImages();

    public List<uploadDto> getUploadOrignalPath();

    public int insertImage(uploadDto uploadDto);

    public int hitUp(ImageDto ImageDto);

    public int updateReply(commentBoardDto commentBoardDto);

    public int delReply(commentBoardDto commentBoardDto);

    public ImageDto getTag(ImageDto imageDto);

    public List<commentBoardDto> getAllcomment();

}
