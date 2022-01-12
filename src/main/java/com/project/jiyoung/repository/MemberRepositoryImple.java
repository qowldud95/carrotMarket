package com.project.jiyoung.repository;

import com.project.jiyoung.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRepositoryImple implements MemberRepository{

    private final EntityManager e;

    /**
     * 회원가입
     */
    @Override
    @Transactional
    public boolean insertMember(Member member) {
        try {
            e.persist(member);
            log.info("member = {}",member);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
