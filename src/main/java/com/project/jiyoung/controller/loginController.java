package com.project.jiyoung.controller;
import com.project.jiyoung.service.MemberLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class loginController {

    private final MemberLoginService memberLoginService;

    /**
     * 로그인
     */
    @GetMapping("login")
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping("login")
    public String login(@Validated @ModelAttribute IdPwDto idPwDto, BindingResult bindingResult){
        log.info("idPwDto = {}", idPwDto);
        if(bindingResult.hasErrors()){
            log.info("Errors 발생");
            return "login";
        }

        //아이디 존재여부
        int result = memberLoginService.idSamePw(idPwDto);
        if(result == 1) {
            //세션생성
            HttpSession session = request.getSession();
            //회원정보 조회
            Optional<Member> loginMember = ml.findLoginMember(idPwDto.getId());
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
        return "redirect:/main";
    }
}
