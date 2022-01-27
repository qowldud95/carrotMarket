package com.project.jiyoung.service;

import com.project.jiyoung.domain.Member;
import com.project.jiyoung.dto.IdPwDto;

import java.util.Optional;

public interface MemberLoginService {
    /**
     * 아이디 비밀번호 일치,불일치 체크
     */
    int idSamePw(IdPwDto idPwDto);

    /**
     * 로그인 멤버 정보 찾기
     */
    Optional<Member> findLoginMember(String id);

}
