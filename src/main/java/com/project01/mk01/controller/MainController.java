package com.project01.mk01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<commentBoardDto> allcomments = imageService.getAllcomment();
        List<uploadDto> getUploadOrignalPath = imageService.getUploadOrignalPath();
        List<String> tagList = new ArrayList<>();
        for (int i = 0; i < allImages.size(); i++) {
            String tag = allImages.get(i).getTag();
            String[] tags = tag.split(",");
            for (int j = 0; j < tags.length; j++) {
                if (!tagList.contains(tags[j])) {
                    tagList.add(tags[j]);

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

    @PostMapping("/updatereply")
    @ResponseBody
    public List<commentBoardDto> updatereply(commentBoardDto commentBoardDto) {

        imageService.updateReply(commentBoardDto);

        List<commentBoardDto> getAllcomment = imageService.getAllcomment();
        return getAllcomment;
    }

    @PostMapping("/getAllCommets")
    @ResponseBody
    public List<commentBoardDto> getAllCommets(commentBoardDto commentBoardDto) {

        List<commentBoardDto> getAllcomment = imageService.getAllcomment();
        return getAllcomment;
    }

    @PostMapping("/delReply")
    @ResponseBody
    public int delReply(commentBoardDto commentBoardDto) {
        imageService.delReply(commentBoardDto);
        return 1;

    }

    @GetMapping("/genCustom")
    public String genCustom() {
        return "/generator/gen7_06Custom";
    }

}
