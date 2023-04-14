package com.project01.mk01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project01.mk01.dto.LoginBoardDto;
import com.project01.mk01.service.LoginBoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
    @Autowired
    LoginBoardService loginBoardService;

    @GetMapping("/login")
    public String login() {

        return "/login/login";
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
            redirectAttributes.addFlashAttribute("title", "로그인 성공.");
            session.setAttribute("board", board);
            log.info("session=================" + session);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("title", "로그인 실패.");
            redirectAttributes.addFlashAttribute("msg", "로그인에 실패했습니다.");

            return "redirect:/login";
        }

    }

    @GetMapping("/signup")
    public String signup(LoginBoardDto loginBoardDto, Model model) {
        model.addAttribute("loginBoardDto", new LoginBoardDto());
        return "/login/signup";
    }

    @PostMapping("/signProcess")
    public String signProcess(@Valid LoginBoardDto loginBoardDto, BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (bindingResult.hasErrors()) {
            log.info("sdsdsdsdsssssssssssss");
            return "/login/signup";
        } else {

            loginBoardService.signup(loginBoardDto);
            redirectAttributes.addFlashAttribute("msg", "회원 가입에 성공했습니다.");
            redirectAttributes.addFlashAttribute("title", "회원 가입 성공");
            return "redirect:/login";
        }

    }

    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(LoginBoardDto loginBoardDto, RedirectAttributes redirectAttributes) {
        log.info(loginBoardDto);

        int result = loginBoardService.idCheck(loginBoardDto);
        log.info("result=====" + result);

        return result;
    }

    @ResponseBody
    @PostMapping("/nickNameCheck")
    public int nickNameCheck(LoginBoardDto loginBoardDto, RedirectAttributes redirectAttributes) {
        log.info(loginBoardDto);

        int result = loginBoardService.nickNameCheck(loginBoardDto);
        log.info("result=====" + result);

        return result;
    }

    @GetMapping("/info")
    public String info() {
        return "/login/info";
    }

    @GetMapping("/modify")
    public String modify() {
        return "/login/modify";
    }

    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes,
            HttpServletResponse response) {
        HttpSession session = request.getSession();
        // session.invalidate();
        session.removeAttribute("board");
        redirectAttributes.addFlashAttribute("msg", "로그아웃되었습니다.");
        redirectAttributes.addFlashAttribute("title", "로그 아웃 성공");
        return "redirect:/";
    }

    // @ResponseBody
    // @PostMapping("/nickNameCheck")
    // public int nickNameCheck(LoginBoardDto loginBoardDto, RedirectAttributes
    // redirectAttributes) {
    // log.info(loginBoardDto);

    // int result = loginBoardService.nickNameCheck(loginBoardDto);
    // log.info("result=====" + result);

    // return result;
    // }

}
