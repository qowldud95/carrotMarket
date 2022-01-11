package com.project.jiyoung.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
@ToString
@Table(name="PRODUCT")
public class Product {
    @Id
    @Column(name="PRODUCT_ID")
    private String id;

    @Column(name="PRODUCT_NAME")
    private String name;

    @Column(name="PRODUCT_IMG")
    private String img;

    @Column(name="PRODUCT_DETAIL")
    private String detail;

    @Column(name="PRODUCT_PRICE")
    private String price;

    @Column(name="PRODUCT_LIKE")
    private String like;

    @Column(name="PRODUCT_REGDATE")
    private LocalDateTime regDate;

    @OneToOne
    //1:1 단방향관계. 하나의 product에 하나의 category가 존재.
    //하나의 category에 하나의 product가 존재하지 않아도 됨.
    @JoinColumn(name="CATEGORY_ID")
    private Category categoryId;

    //FK
    //N:1 관계.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;



}
