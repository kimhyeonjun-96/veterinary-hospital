package com.myProject.treatment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myProject.treatment.domain.user.dao.JpaMemberRepository;
import com.myProject.treatment.domain.user.dao.MemberRepository;
import com.myProject.treatment.domain.user.service.MemberServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private final MemberRepository memberRepository;
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    @Bean
    public MemberServiceImpl memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
}
