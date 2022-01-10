package com.project.jiyoung.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class myPageController {
    /**
     * 나의 판매 상품
     */
    @GetMapping("myProductList")
    public String myProductList(Model model){
        return "myProductList";
    }

    /**
     * 나의 당근
     */
    @GetMapping("myPage")
    public String myPage(Model model){
        return "myPage";
    }

    /**
     * 나의 당근 (프로필 수정)
     */
    @GetMapping("myPageEdit")
    public String myPageEdit(Model model){
        return "myPageEdit";
    }

}

