package com.myProject.treatment.domain.welcom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
    @GetMapping("/")
    public String welcom(){
        return "Hello, world!";
    }
}
