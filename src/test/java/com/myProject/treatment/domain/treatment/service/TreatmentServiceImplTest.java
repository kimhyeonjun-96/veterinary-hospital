package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.service.AnimalService;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.service.MemberService;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class TreatmentServiceImplTest {

    @Autowired EntityManager em;
    @Autowired TreatmentService treatmentService;
    @Autowired TreatmentRepository treatmentRepository;

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Autowired AnimalService animalService;
    @Autowired AnimalRepository animalRepository;

    @Autowired DoctorService doctorService;
    @Autowired DoctorRepository doctorRepository;

    @Test
    public void 진료_신청_및_예약(){
        //given
//        Member memberDTO = memberService.findOneMember(14L).get();


        // when

        // then

    }


}