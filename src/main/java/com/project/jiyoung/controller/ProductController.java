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
}
