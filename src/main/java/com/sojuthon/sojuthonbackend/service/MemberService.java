package com.sojuthon.sojuthonbackend.service;


import com.sojuthon.sojuthonbackend.dto.MemberDto;
import com.sojuthon.sojuthonbackend.dto.member.LoginMember;
import com.sojuthon.sojuthonbackend.dto.member.RegisterMember;
import com.sojuthon.sojuthonbackend.dto.member.RegisterMember.Request;
import com.sojuthon.sojuthonbackend.entity.Member;
import com.sojuthon.sojuthonbackend.exception.DuplicatePhoneException;
import com.sojuthon.sojuthonbackend.exception.NotLoginException;
import com.sojuthon.sojuthonbackend.repository.MemberRepository;
import com.sojuthon.sojuthonbackend.utils.SHA256Util;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void register(Request request) {
        Optional<Member> optinalduplicatePhone = memberRepository.findByPhone(request.getPhone());

        if (optinalduplicatePhone.isPresent()) {
            throw new DuplicatePhoneException("이미 존재하는 폰번호 입니다.");
        }

        memberRepository.save(Member.builder()
                .phone(request.getPhone())
                .password(SHA256Util.encryptSHA256(request.getPassword()))
                .name(request.getName())
                .nickname(request.getNickname())
                .introduce(request.getIntroduce())
                .birth(request.getBirth())
                .profileImg(request.getProfileImg())
                .build());
    }

    public MemberDto login(LoginMember.Request request) {
        String phone = request.getPhone();
        String password = request.getPassword();

        Optional<Member> optinalduplicatePhone = memberRepository.findByPhone(phone);

        if (optinalduplicatePhone.isPresent()) {
            throw new DuplicatePhoneException("이미 존재하는 폰번호 입니다.");
        }

        Optional<Member> optionalMember = memberRepository.findByPhoneAndPassword(phone,
                password);

        if (!optionalMember.isPresent()) {
            throw new NotLoginException("존재하지 않는 회원입니다.");
        }

        Member member = optionalMember.get();

        return MemberDto.of(member);

    }
}
