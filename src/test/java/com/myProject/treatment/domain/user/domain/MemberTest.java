package com.myProject.treatment.domain.user.domain;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.domain.Animal;
import com.myProject.treatment.domain.animal.domain.Animal_type;
import com.myProject.treatment.domain.animal.service.AnimalService;
import com.myProject.treatment.domain.user.dao.MemberRepository;
import com.myProject.treatment.domain.user.service.MemberService;
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
        Member member = new Member("test01", "test01", "test01", "010-1111-1111", "서울시 강동구");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getID()).isEqualTo(findMember.getID());

    }

    @Test
    public void 회원_반료동물_회원가입(){
        Member member = new Member("test01", "test01", "test01", "010-1111-1111", "서울시 강동구");
        Long member_id = memberService.join(member);

        Animal animal = new Animal("test01_동물", 60, 5, Animal_type.CAT, member);
        Animal regist_animal = animalService.regist(animal, member_id);


        assertThat(animal.getMemberID()).isEqualTo(regist_animal.getMemberID());
    }
}