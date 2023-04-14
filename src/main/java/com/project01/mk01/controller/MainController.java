package com.project01.mk01.controller;

import java.util.ArrayList;
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
    public String index(Model model, Model model2) {
        List<ImageDto> allImages = imageService.getAllimages();
        List<String> tagList = new ArrayList<>();
        for (int i = 0; i < allImages.size(); i++) {
            // log.info(allImages.get(i).getTag());
            String tag = allImages.get(i).getTag();
            String[] tags = tag.split(",");
            log.info(tags);
            for (int j = 0; j < tags.length; j++) {
                if (!tagList.contains(tags[j])) {
                    tagList.add(tags[j]);
                    log.info(tags[j]);

                }
            }

        }

        model.addAttribute("allImages", allImages);
        model2.addAttribute("tags", tagList);

        return "/index/index";
    }

    @GetMapping("/gen")
    public String generator() {
        return "/generator/gen6";
    }
}
