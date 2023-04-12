package com.project01.mk01.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project01.mk01.dto.ImageDto;

@Mapper
public interface ImageDao {

    int insertGallery(ImageDto imageDto);

    List<ImageDto> getAllimages();

}
