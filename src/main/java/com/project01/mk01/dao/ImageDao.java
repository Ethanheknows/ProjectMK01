package com.project01.mk01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.commentBoardDto;
import com.project01.mk01.dto.uploadDto;

@Mapper
public interface ImageDao {

    int insertGallery(ImageDto imageDto);

    List<ImageDto> getAllimages();

    List<uploadDto> getUploadOrignalPath();

    List<commentBoardDto> getAllcomment();

    int insertImage(uploadDto uploadDto);
}
