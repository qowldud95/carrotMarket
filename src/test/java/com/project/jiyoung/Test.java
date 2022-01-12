package com.project.jiyoung;

import com.project.jiyoung.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@Slf4j
public class Test {
    @PersistenceContext
    EntityManager entityManager;

    @org.junit.jupiter.api.Test
    public void test(){
        Member member = new Member();

        member.setId("qowldud95");
        member.setName("배지영");
        member.setPhone("01064794472");
        member.setNickname("배찌");
        member.setPw("1234");
        member.setArea("당근");

        entityManager.persist(member);

    }

}
