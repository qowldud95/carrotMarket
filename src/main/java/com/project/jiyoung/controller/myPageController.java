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

}

