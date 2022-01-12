package com.project.jiyoung.controller;

import com.project.jiyoung.dto.MemberJoinGetDto;
import com.project.jiyoung.service.MemberJoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberJoinController {

    private final MemberJoinService memberJoinService;

    /**
     * 회원가입
     */
    @GetMapping("member-join")
    public String memberJoin(Model model){
        model.addAttribute("memberJoinGetDto", new MemberJoinGetDto());
        return "memberJoin";
    }

    @PostMapping("member-join")
    public String memberJoin(@Validated @ModelAttribute MemberJoinGetDto memberJoinGetDto, BindingResult bindingResult){
        log.info("memberJoinGetDto = {}", memberJoinGetDto);
        if(bindingResult.hasErrors()){
            log.info("Errors 발생");
            return "memberJoin";
        }
        boolean result = memberJoinService.makeMember(memberJoinGetDto);

        log.info("result="+result);
        return "redirect:/login";
    }



}
