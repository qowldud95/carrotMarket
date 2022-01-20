package com.project.jiyoung.service;

import com.project.jiyoung.dto.IdPwDto;

public interface MemberLoginService {
    /**
     * 아이디 비밀번호 일치,불일치 체크
     */
    int idSamePw(IdPwDto idPwDto);
}
