package com.sojuthon.sojuthonbackend.dto.member;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class RegisterMember {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String phone;

        private String password;

        private String name;

        private String nickname;

        private String introduce;

        private String birth;

        private MultipartFile file;

        private String profileImg;
    }


}
