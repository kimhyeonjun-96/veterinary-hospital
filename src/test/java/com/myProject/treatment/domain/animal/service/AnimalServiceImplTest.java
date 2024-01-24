package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AnimalServiceImplTest {

    @Autowired MemberRepository memberRepository;
    @Autowired AnimalRepository animalRepository;

    /*@Test
    public void 회원_특정_반려동물(){
        MemberDTO aMemberDTO = memberService.findOneMember(14L);

        List<AnimalDTO> animalList = animalService.getAnimalList(aMemberDTO.getId());

        for(AnimalDTO animal : animalList){
            System.out.println(animal);
        }
    }*/

}