package com.project.jiyoung.service;

import com.project.jiyoung.dto.MemberJoinGetDto;

public interface MemberJoinService {
    /**
     * 회원등록
     */
    public boolean makeMember(MemberJoinGetDto member);

    /**
     * 비밀번호 암호화
     */
    public String SHA512(String pw, String hash);

}
