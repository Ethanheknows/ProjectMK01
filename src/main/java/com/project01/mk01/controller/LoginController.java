package com.project01.mk01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project01.mk01.dto.LoginBoardDto;
import com.project01.mk01.dto.uploadDto;
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
        LoginBoardDto board = loginBoardService.searchBoard(loginBoardDto);
        if (board != null) {
            HttpSession session = request.getSession();
            redirectAttributes.addFlashAttribute("msg", "로그인에 성공했습니다.");
            redirectAttributes.addFlashAttribute("title", "로그인 성공.");
            session.setAttribute("board", board);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("title", "로그인 실패.");
            redirectAttributes.addFlashAttribute("msg", "로그인에 실패했습니다.");

            return "redirect:/login";
        }

    }

    @GetMapping("/delete")
    public String delete() {

        return "/login/delete";
    }

    @PostMapping("/deleteAccountProcess")
    @ResponseBody
    public Map<String, Object> deleteAccountProcess(HttpServletRequest request, LoginBoardDto loginBoardDto,
            RedirectAttributes redirectAttributes) {

        int result = loginBoardService.deleteAccount(loginBoardDto);

        HttpSession session = request.getSession();
        session.removeAttribute("board");

        Map<String, Object> sendJson = new HashMap<>();
        if (result > 0) {
            // replyJsonDto.setMsg("ok");
            sendJson.put("msg", "ok");

        } else {
            // replyJsonDto.setMsg("fail");
            sendJson.put("msg", "fail");
        }
        // return replyJsonDto;

        return sendJson;
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
        String errormessage = "";
        int idChk = loginBoardService.idCheck(loginBoardDto);
        int nickChk = loginBoardService.nickNameCheck(loginBoardDto);
        String pw = loginBoardDto.getUserPw();
        String pwchk = loginBoardDto.getUserPwCheck();
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {

            errorMap.put(error.getField(), error.getDefaultMessage());
            errormessage = error.getDefaultMessage();
        }
        if (nickChk != 0) {
            redirectAttributes.addFlashAttribute("msg", "이미 사용중이거나 탈퇴한 닉네임입니다.");
            return "redirect:/signup";
        } else if (idChk != 0) {
            redirectAttributes.addFlashAttribute("msg", "이미 사용중이거나 탈퇴한 ID입니다.");
            return "redirect:/signup";
        } else if (!pw.equals(pwchk)) {
            redirectAttributes.addFlashAttribute("msg", "비밀번호가 비밀번호 확인 입력칸과 일치하지 않습니다.");
            return "redirect:/signup";
        } else if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", errormessage);
            return "redirect:/signup";
        } else {

            loginBoardService.signup(loginBoardDto);
            redirectAttributes.addFlashAttribute("msg", "회원 가입에 성공했습니다.");
            redirectAttributes.addFlashAttribute("title", "회원 가입 성공");
            return "redirect:/login";
        }

    }

    @PostMapping("/modifyProcess")
    public String modifyProcess(@Valid LoginBoardDto loginBoardDto, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model, HttpSession session) {
        String errormessage = "";
        Map<String, String> errorMap = new HashMap<>();
        int nickChk = loginBoardService.nickNameCheck(loginBoardDto);
        String nickName = loginBoardDto.getNickName();
        String pw = loginBoardDto.getUserPw();
        String pwchk = loginBoardDto.getUserPwCheck();
        Object obj = session.getAttribute("board");

        LoginBoardDto board = (LoginBoardDto) obj;

        for (FieldError error : bindingResult.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
            errormessage = error.getDefaultMessage();
        }
        if (nickChk != 0 && !nickName.equals(board.getNickName())) {
            redirectAttributes.addFlashAttribute("msg", "이미 사용중이거나 탈퇴한 닉네임입니다.");
            return "redirect:/modify";
        } else if (!pw.equals(pwchk)) {
            redirectAttributes.addFlashAttribute("msg", "비밀번호가 비밀번호 확인 입력칸과 일치하지 않습니다.");
            return "redirect:/modify";
        } else if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", errormessage);

            return "redirect:/modify";
        } else {

            loginBoardService.updateBoard(loginBoardDto);
            redirectAttributes.addFlashAttribute("msg", "회원정보가 수정되었니다.");
            redirectAttributes.addFlashAttribute("title", "회원 수정 성공");
            return "redirect:/info";
        }

        // board 객체를 사용하는 코드 작성

    }

    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(LoginBoardDto loginBoardDto, RedirectAttributes redirectAttributes) {

        int result = loginBoardService.idCheck(loginBoardDto);

        return result;
    }

    @ResponseBody
    @PostMapping("/nickNameCheck")
    public int nickNameCheck(LoginBoardDto loginBoardDto, RedirectAttributes redirectAttributes) {

        int result = loginBoardService.nickNameCheck(loginBoardDto);

        return result;
    }

    @GetMapping("/info")
    public String info(Model model, HttpServletRequest request, HttpSession httpSession) {
        List<uploadDto> alluploads = loginBoardService.getAllupload();
        model.addAttribute("alluploads", alluploads);
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

}
