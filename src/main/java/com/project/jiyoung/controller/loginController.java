package com.project.jiyoung.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class loginController {
    /**
     * 로그인
     */
    @GetMapping("login")
    public String loginPage(Model model){
        return "login";
    }
}
