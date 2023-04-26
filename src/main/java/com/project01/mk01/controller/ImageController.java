package com.project01.mk01.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.uploadDto;
import com.project01.mk01.service.ImageService;

@Controller
@Log4j2
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/insert")
    public String insert(HttpServletRequest request) {
        String old_url = request.getHeader("referer");
        if (!old_url.equals("null")) {
            return "/gallery/insert";
        } else {
            return "/";

        }

    }

    @PostMapping("/insertProcess")
    public String insertProcess(ImageDto imageDto) {
        imageService.insertGallery(imageDto);

        return "redirect:/";
    }

    @PostMapping("/saveImage")
    public String saveImage(uploadDto uploadDto) {
        imageService.insertImage(uploadDto);
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/hitProcess")
    public int hitProcess(ImageDto imageDto) {
        imageService.hitUp(imageDto);

        return 1;
    }

    @PostMapping("/getTag")
    @ResponseBody
    public ImageDto getTag(ImageDto imageDto) {
        ImageDto getTag = imageService.getTag(imageDto);

        return getTag;
    }
}
