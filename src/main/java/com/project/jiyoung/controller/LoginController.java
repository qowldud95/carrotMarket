package com.project.jiyoung.controller;
import com.project.jiyoung.domain.Member;
import com.project.jiyoung.dto.IdPwDto;
import com.project.jiyoung.service.MemberLoginService;
import com.project.jiyoung.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {

    private final MemberLoginService memberLoginService;

    /**
     * 로그인
     */
    @GetMapping("login")
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String loginInfo(@Validated @ModelAttribute("member") IdPwDto idPwDto, BindingResult bindingResult, @RequestParam(defaultValue = "/main")String redirectURL, HttpServletRequest request){
        log.info("idPwGetDto ={}", idPwDto);
        if(bindingResult.hasErrors()) {
            return "login";
        }
        //아이디 존재여부
        int result = memberLoginService.idSamePw(idPwDto);
        if(result == 1) {
            //세션생성
            HttpSession session = request.getSession();
            //회원정보 조회
            Optional<Member> loginMember = memberLoginService.findLoginMember(idPwDto.getId());
            log.info("loginMember1 = {}", loginMember);
            //세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember.get());
            log.info("1redirectURL:{}",redirectURL);
            //세션에 로그인 id 보관
            session.setAttribute("loginId", idPwDto.getId());

            if( redirectURL.equals("null") ){
                redirectURL = "/main";
            }
            log.info("redirectURL={}",redirectURL);

            return "redirect:"+redirectURL;
        } else if(result == -1) {
            bindingResult.addError(new ObjectError("idPwErr", null, null,"비밀번호가 틀렸습니다."));
        } else {
            bindingResult.addError(new ObjectError("idPwErr", null, null,"아이디가 존재하지 않습니다."));
        }
        log.info("{}", result);
        return "productList";
    }
    /**
     * 로그인 정보 일치 여부 체크
     *//*
    @PostMapping("login/loginCheck")
    @ResponseBody
    public boolean loginCheck(@Validated @RequestBody IdPwDto idPwDto, BindingResult bindingResult) {
        log.info("member = {}", idPwDto);
        if(bindingResult.hasErrors()) {
            return false;
        }
        //id, pw 일치하지 않을 경우
        if(memberLoginService.idSamePw(idPwDto) != 1) {
            return false;
        }else {
            return true;
        }
    }*/

}
