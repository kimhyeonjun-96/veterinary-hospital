package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class AnimalServiceImplTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Autowired AnimalService animalService;
    @Autowired AnimalRepository animalRepository;

    @Test
    public void 회원_특정_반려동물(){
        MemberDTO memberDTO = memberService.findOneMember(14L);

        List<AnimalDTO> animalList = animalService.getAnimalList(memberDTO.getId());

        for(AnimalDTO animal : animalList){
            System.out.println(animal);
            System.out.println("Pull Requests Test 02!!!!");
            System.out.println("PR02 커밋 테스트다아아아아아!!!");
            System.out.println("Pull Request Test01!!!");
            System.out.println("Pull Request Test01 커밋테스트!!!");
            System.out.println("================================");
        }
    }

}