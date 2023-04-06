package com.project01.mk01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project01.mk01.dto.LoginBoardDto;
import com.project01.mk01.service.LoginBoardService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {
    @Autowired
    LoginBoardService loginBoardService;

    @GetMapping("/login")
    public String login() {

        return "/login/login";
    }

    @GetMapping("/")
    public String main() {

        return "/login/main";
    }

    @PostMapping("/loginProcess")
    public String loginProcess(LoginBoardDto loginBoardDto, RedirectAttributes redirectAttributes,
            HttpServletRequest request) {
        log.info("Dto========" + loginBoardDto);
        LoginBoardDto board = loginBoardService.searchBoard(loginBoardDto);
        log.info("board========" + board);
        if (board != null) {
            HttpSession session = request.getSession();
            redirectAttributes.addFlashAttribute("msg", "로그인에 성공했습니다.");
            session.setAttribute("board", board);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("msg", "로그인에 실패했습니다.");

            return "redirect:/login/login";
        }

    }

}
