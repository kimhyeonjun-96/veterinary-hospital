package com.myProject.treatment.domain.member.domain;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.service.AnimalService;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberTest {

    @Autowired  MemberService memberService;
    @Autowired  MemberRepository memberRepository;

    @Autowired AnimalService animalService;
    @Autowired AnimalRepository animalRepository;

    @Test
    public void 회원만가입(){
        // given
        MemberDTO memberDTO = new MemberDTO("test01", "test01", "test01", "010-1111-1111", "서울시 강동구");

        // when
        MemberDTO memberDTO1 = memberService.signupMember(memberDTO);

        // then
        Member findMemberDTO = memberService.findOneMember(memberDTO1.getId()).get();
        assertThat(memberDTO.getId()).isEqualTo(findMemberDTO.getId());

    }

    @Test
    public void 회원_반료동물_등록(){
        Member memberDTO = new Member("test01", "test01", "test01", "010-1111-1111", "서울시 강동구");

        Animal animal = new Animal("test01_동물", 60, 5, "CAT", memberDTO);
        Animal regist_animal = animalService.regist(animal, memberDTO.getId());


        assertThat(animal.getMemberID()).isEqualTo(regist_animal.getMemberID());
    }
}