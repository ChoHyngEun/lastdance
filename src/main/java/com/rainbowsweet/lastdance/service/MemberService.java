package com.rainbowsweet.lastdance.service;

import com.rainbowsweet.lastdance.entity.Member;
import com.rainbowsweet.lastdance.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member){
        member.setPassword(encodePassword(member.getPassword()));
        return memberRepository.save(member);
    }

    private String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
            /*알고리즘이 존재하지않을시에 발생하는 예외, 해당예외가 발생하면 RuntimeException으로 래핑하여 예외를 전파함.
            * 잘못된 알고리즘의 이름을 사용하거나, 암호화에 필요한 알고리즘이 런타임에 없어질때를 대비하여 필요함.*/
        }
    }
    public Member authenticate(String memberId, String password) {
        Member member = memberRepository.findByMemberId(memberId);
        if (member != null && member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }
    }/* userrepository.findbymemberid메서드를 사용하여 주어진 사용자 이름에 해당하는 사용자를 데이터베이스에서 찾음.
        * 그런 다음 사용자의 비밀번호를 입력된 비밀번호와 비교하여 일치하는 경우 사용자 객체를 반환하고, 그렇지 않으면 null을 반환함.
        * 인증에 성공한 경우 반환된 사용자 객체를 이용하여 로그인한 사용자에 대한 추가적인 작업을 수행할 수 있음.*/

    //로그인 카운트 1씩 증가
    public void incrementLoginCount(Member member) {
        member.setLogincount(member.getLogincount() + 1);
        memberRepository.save(member);
    }

}
