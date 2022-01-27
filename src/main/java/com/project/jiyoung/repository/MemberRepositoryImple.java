package com.project.jiyoung.repository;

import com.project.jiyoung.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    /**
     * id로 전체정보조회
     */
    @Override
    public Optional<Member> findMemberByLoginId(String id) {
        return findAll().stream()
                .filter(m->m.getId().equals(id))
                .findAny();
    }
    public List<Member> findAll() {
        return e.createQuery("select m from Member m")
                .getResultList();
    }

    /**
     * 아이디 비밀번호 확인
     * @return
     */
    @Override
    public List<Object[]> findSaltAndPwById(String id) {
        try{
            List<Object[]> result = e.createQuery("select m.pw from Member m where m.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            return result;
        }catch (Exception e) {
            return null;
        }
    }

}
