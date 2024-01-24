package com.myProject.treatment.domain.member.domain;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberTest {

    @Autowired private MemberServiceImpl memberService;
    @Autowired private AnimalServiceImpl animalService;
    @Autowired  MemberRepository memberRepository;
    @Autowired AnimalRepository animalRepository;

    @Test
    public void 회원만가입(){
        // given
        MemberDTO aMemberDTO = new MemberDTO("test01", "test01", "test01", "010-1111-1111", "서울시 강동구");

        // when
        MemberDTO memberDTO1 = memberService.signupMember(aMemberDTO);

        // then
        MemberDTO findMemberDTO = memberService.findOneMember(memberDTO1.getId());
        assertThat(aMemberDTO.getId()).isEqualTo(findMemberDTO.getId());

    }

    @Test
    public void 회원_반료동물_등록(){
        java.lang.Long memberId = 14L;

        AnimalDTO animal = new AnimalDTO("test01_동물", 60, 5, "CAT", memberId);

        AnimalDTO regist_animal = animalService.registAnimal(animal, memberId);


        assertThat(animal.getMemberId()).isEqualTo(regist_animal.getMemberId());
    }
}