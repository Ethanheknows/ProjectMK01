package com.project01.mk01.controller;

import java.util.List;
import lombok.extern.log4j.Log4j2;
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
    public String view(Model model) {
        log.info("allImages===========");

        List<ImageDto> allImages = imageService.getAllimages();
        log.info("allImages===========" + allImages);
        model.addAttribute("allImages", allImages);

        log.info("aaaaaaaaaaaaaaaaaaaaaaaaa");
        return "/gallery/view";
    }

    @GetMapping("/insert")
    public String insert() {
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaa");
        return "/gallery/insert";
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
