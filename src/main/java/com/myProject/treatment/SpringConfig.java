package com.myProject.treatment;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.dao.JpaAnimalRepository;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.member.dao.JpaMemberRepository;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.service.MemberServiceImpl;
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
    public AnimalServiceImpl animalService(){
        return new AnimalServiceImpl(animalRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public AnimalRepository animalRepository(){
        return new JpaAnimalRepository(em);
    }
}
