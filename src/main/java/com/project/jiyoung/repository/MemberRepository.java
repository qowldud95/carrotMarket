package com.project.jiyoung.repository;

import com.project.jiyoung.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /**
     * 회원가입
     */
    public boolean insertMember(Member member);

    /**
     * id로 전체정보조회
     */
    public Optional<Member> findMemberByLoginId(String id);

    /**
     * 아이디 비밀번호 확인
     */
    public List<Object[]> findSaltAndPwById(String id);
}
