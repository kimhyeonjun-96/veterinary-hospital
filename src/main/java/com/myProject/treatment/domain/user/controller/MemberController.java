package com.myProject.treatment.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    
    @GetMapping("/members/mypage")
    public String myPage(){
        return "myPage";
    }
}
