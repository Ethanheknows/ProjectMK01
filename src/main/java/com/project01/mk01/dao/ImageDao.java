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

    List<ImageDto> orderByHitImages();

    List<uploadDto> getUploadOrignalPath();

    int insertImage(uploadDto uploadDto);

    int hitUp(ImageDto imageDto);

    List<commentBoardDto> getAllcomment();

    int updateReply(commentBoardDto commentBoardDto);

    int delReply(commentBoardDto commentBoardDto);

    ImageDto getTag(ImageDto imageDto);

}
