package com.project.jiyoung.repository;

import com.project.jiyoung.domain.Member;

public interface MemberRepository {
    /**
     * 회원가입
     */
    public boolean insertMember(Member member);
}
