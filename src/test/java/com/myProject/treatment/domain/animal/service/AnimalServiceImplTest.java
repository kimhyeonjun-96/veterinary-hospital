package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AnimalServiceImplTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Autowired AnimalService animalService;
    @Autowired AnimalRepository animalRepository;

    @Test
    public void 회원_특정_반려동물(){
        Member member = memberService.findOne(14L).get();

        List<Animal> animalList = animalService.getAnimal(member.getID());

        for(Animal animal : animalList){
            System.out.println(animal);
        }

    }

}