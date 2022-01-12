package com.project.jiyoung.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MemberJoinGetDto {
    @NotBlank(message="아이디를 입력해주세요.")
    private String id;

    @NotBlank(message="비밀번호를 입력해주세요.")
    private String pw;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "핸드폰번호 입력해주세요.")
    private String phone;

    private String area;

    private String img;

    //private LocalDateTime regDate;

}
