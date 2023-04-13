package com.project01.mk01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.service.ImageService;

import groovy.util.logging.Slf4j;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MainController {
    @Autowired
    ImageService imageService;

    @GetMapping("/")
    public String index(Model model) {
        List<ImageDto> allImages = imageService.getAllimages();
        log.info("allImages===========" + allImages);
        model.addAttribute("allImages", allImages);

        return "/index/index";
    }

    @GetMapping("/gen")
    public String generator() {
        return "/generator/gen6";
    }
}
