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
public class MemberJoinController {
    /**
     * 초기화면
     */
    @GetMapping("member-join")
    public String memberJoin(Model model){
        return "memberJoin";
    }
}
