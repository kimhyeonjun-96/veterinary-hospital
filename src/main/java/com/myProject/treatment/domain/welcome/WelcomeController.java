package com.myProject.treatment.domain.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcom(){
        System.out.println("PR 테스트 중입니다. - 01");
        return "Welcome Page!";
    }
}
