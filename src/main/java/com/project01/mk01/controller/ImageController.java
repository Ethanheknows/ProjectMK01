package com.project01.mk01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import lombok.extern.log4j.Log4j2;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project01.mk01.dto.ImageDto;
import com.project01.mk01.service.ImageService;

@Controller
@Log4j2
public class ImageController {

    @Autowired
    ImageService imageService;

    // @GetMapping({ "/list" })
    // public String list(Model model) {
    // List<ImageDto> imageList = imageService.getAllList();
    // log.info(imageList);
    // model.addAttribute("imageList", imageList);
    // return "/gallery/list";
    // }
    @GetMapping("/view")
    public String view(Model model, Model model2) {
        log.info("allImages===========");

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

        return "/gallery/view";
    }

    @GetMapping("/insert")
    public String insert(HttpServletRequest request) {
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaa");
        String old_url = request.getHeader("referer");
        if (old_url.equals("http://localhost:9091/")) {
            log.info(" 글쓰기 폼 ======> " + old_url);
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

    // @PostMapping("/getReply/{no}")
    // @ResponseBody
    // public List<ReplyDto> getReply(@PathVariable("no") int no) {
    // List<ReplyDto> replyList = galleryService.getAllReply(no);
    // return replyList;
    // }

    // @GetMapping("/view/{no}")
    // public String view(@PathVariable("no") int no, Model model) {
    // GalleryDto galleryDto = galleryService.viewGallery(no);
    // model.addAttribute("galleryDto", galleryDto);
    // return "/gallery/view";
    // }

    // @PostMapping("/insertReply")
    // @ResponseBody
    // public List<ReplyDto> insertReply(ReplyDto replyDto) {
    // int result = galleryService.insertReply(replyDto);
    // List<ReplyDto> replyList = galleryService.getAllReply(
    // replyDto.getGalleryId()
    // );
    // if (result > 0) {
    // return replyList;
    // } else {
    // return replyList;
    // }
    // }
}
