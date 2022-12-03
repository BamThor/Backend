package com.sojuthon.sojuthonbackend.controller;

import com.sojuthon.sojuthonbackend.dto.member.LoginMember;
import com.sojuthon.sojuthonbackend.dto.member.RegisterMember;
import com.sojuthon.sojuthonbackend.service.MemberService;
import com.sojuthon.sojuthonbackend.utils.S3Uploader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final S3Uploader s3Uploader;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginMember.Request request) {
        memberService.login(request);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterMember.Request request) throws IOException {
        request.setProfileImg(s3Uploader.upload(request.getFile(), "images"));
        memberService.register(request);
    }






}
