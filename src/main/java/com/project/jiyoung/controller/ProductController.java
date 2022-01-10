package com.project.jiyoung.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ProductController {
    /**
     * 상품 list
     */
    @GetMapping("productList")
    public String productListPage(Model model){
        return "productList";
    }

    /**
     * 상품 등록
     */
    @GetMapping("productRegistration")
    public String productRegistration(Model model){
        return "productRegistration";
    }

    /**
     * 상품 상세
     */
    @GetMapping("productDetail")
    public String productDetail(Model model){
        return "productDetail";
    }

    /**
     * 댓글 남기기
     */
    @GetMapping("commentRegistration")
    public String commentRegistration(Model model){
        return "commentRegistration";
    }
}
