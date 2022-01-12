package com.project.jiyoung.service;

import com.project.jiyoung.domain.Member;
import com.project.jiyoung.dto.MemberJoinGetDto;
import com.project.jiyoung.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberJoinServiceImple implements MemberJoinService{

    private final MemberRepository memberRepository;

    @Override
    public boolean makeMember(MemberJoinGetDto memberJoinGetDto) {
        String encryption = encryption();
        Member member = new Member();
        member.setId(memberJoinGetDto.getId());
        member.setPw(SHA512(memberJoinGetDto.getPw(), encryption));
        member.setName(memberJoinGetDto.getName());
        member.setNickname(memberJoinGetDto.getNickname());
        member.setPhone(memberJoinGetDto.getPhone());
        member.setRegDate(LocalDateTime.now());

        log.info("id :: "+member.getId());
        log.info("pw :: "+member.getPw());
        log.info("name :: "+member.getName());
        log.info("town :: " + member.getTown());
        log.info("regDate :: "+String.valueOf(member.getRegDate()));

        boolean result = memberRepository.insertMember(member);

        return result;
    }

    /**
     * 비밀번호 암호화
     */
    public String encryption(){
        String encryption="";
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            encryption = new String(java.util.Base64.getEncoder().encode(bytes));}
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } return encryption;
    }
    public String SHA512(String pw, String hash) {
        String salt = hash+pw;
        String hex = null;
        try {
            MessageDigest msg = MessageDigest.getInstance("SHA-512");
            msg.update(salt.getBytes());
            hex = String.format("%128x", new BigInteger(1, msg.digest()));
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return hex;
    }
}
