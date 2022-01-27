package com.project.jiyoung.service;

import com.project.jiyoung.domain.Member;
import com.project.jiyoung.dto.IdPwDto;
import com.project.jiyoung.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberLoginServiceImple implements MemberLoginService{

    private final MemberRepository memberRepository;
    private final MemberJoinService memberJoinService;

    /**
     * 아이디 비밀번호 일치,불일치 체크
     */
    @Override
    public int idSamePw(IdPwDto idPwDto) {
        String id = idPwDto.getId();
        String salt = null;
        String loginPw = null;
        String pw = idPwDto.getPw();
        List<Object[]> saltAndPw = memberRepository.findSaltAndPwById(id);

        //아이디 불일치
        if(saltAndPw.isEmpty()) {
            return 0;
        }

        //비번 체크
        for(Object[] info : saltAndPw) {
            salt = (String)info[0];
            loginPw = (String)info[1];
        }
        String dbPw = memberJoinService.SHA512(pw, salt);

        //아이디와 비번 일치
        if(dbPw.equals(loginPw)) {
            return 1;
        }

        //아이디 일치, 비번 불일치
        return -1;
    }
    /**
     * 로그인 멤버 정보 찾기
     */
    @Override
    public Optional<Member> findLoginMember(String id) {
        return memberRepository.findMemberByLoginId(id);
    }
}
