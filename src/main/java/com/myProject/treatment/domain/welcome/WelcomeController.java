package com.myProject.treatment.domain.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcom(){
        return "Welcome Page!";
    }
}
