package com.project.jiyoung.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MEMBER")
@ToString
@Getter @Setter
public class Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id;

    @Column(name="MEMBER_PW")
    private String pw;

    @Column(name="MEMBER_NAME")
    private String name;

    @Column(name="MEMBER_NICKNAME")
    private String nickname;

    @Column(name="MEMBER_PHONE")
    private String phone;

    @Column(name="MEMBER_TOWN")
    private String town;

    @Column(name="MEMBER_IMG")
    private String img;

    @Column(name="MEMBER_REGDATE")
    private LocalDateTime regDate;

    //1:N관계
    //Member Table에는 존재하지 않지만, Member에 속하는 products를 객체안에 저장
    @OneToMany(mappedBy = "member")
    private List<Product> products;

}
