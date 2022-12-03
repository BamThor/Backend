package com.sojuthon.sojuthonbackend.dto;

import com.sojuthon.sojuthonbackend.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private Long id;

    private String phone;

    private String password;

    private String nickname;

    private String name;

    private String introduce;

    private String birth;

    private String profileImg;

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .name(member.getName())
                .introduce(member.getIntroduce())
                .birth(member.getBirth())
                .profileImg(member.getProfileImg())
                .build();
    }

}
