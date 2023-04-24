package com.project01.mk01.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.dto.commentBoardDto;
import com.project01.mk01.dto.uploadDto;
import com.project01.mk01.service.ImageService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MainController {
    @Autowired
    ImageService imageService;

    @GetMapping("/")
    public String index(Model model, Model model2, Model model3, Model model4, Model model5) {
        List<ImageDto> allImages = imageService.getAllimages();
        List<ImageDto> orderByHitImages = imageService.orderByHitImages();
        log.info(orderByHitImages);
        List<commentBoardDto> allcomments = imageService.getAllcomment();
        List<uploadDto> getUploadOrignalPath = imageService.getUploadOrignalPath();
        List<String> tagList = new ArrayList<>();
        for (int i = 0; i < allImages.size(); i++) {
            log.info(allImages.get(i).getTag());
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
        model3.addAttribute("allcomments", allcomments);
        model4.addAttribute("getUploadOrignalPath", getUploadOrignalPath);
        model5.addAttribute("orderByHitImages", orderByHitImages);
        return "/index/index";
    }

    @GetMapping("/gen")
    public String generator() {
        return "/generator/gen7_06";
    }

}
