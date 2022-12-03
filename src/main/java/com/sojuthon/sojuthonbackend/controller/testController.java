package com.sojuthon.sojuthonbackend.controller;

import com.sojuthon.sojuthonbackend.utils.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class testController {

    private final S3Uploader s3Uploader;


}
