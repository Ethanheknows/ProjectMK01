package com.project01.mk01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {

        return "/index/index";
    }

    @GetMapping("/gen")
    public String generator() {
        return "/generator/gen6";
    }
}
