package com.project.jiyoung.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="CATEGORY")
public class Category {
    @Id
    @Column(name="CATEGORY_ID")
    private String id;

    @Column(name="CATEGORY_NAME")
    private String name;

}
