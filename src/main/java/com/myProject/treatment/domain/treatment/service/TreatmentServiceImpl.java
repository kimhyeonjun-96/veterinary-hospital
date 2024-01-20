package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalService;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberService;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService{

    private final TreatmentRepository treatmentRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final AnimalService animalService;
    private final AnimalRepository animalRepository;
    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;

    @Override
    public TreatmentDTO createTreatment(TreatmentDTO treatmentDTO) {
        Member member = memberRepository.findById(treatmentDTO.getMemberDTO().getId()).get();
        Animal animal = animalRepository.findById(treatmentDTO.getAnimal().getId()).get();
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctor().getId()).get();

        Treatment saveTreatment = treatmentRepository.saveTreatment(new Treatment(treatmentDTO.getPurpose(), member, animal, doctor));

        MemberDTO oneMember = memberService.findOneMember(saveTreatment.getMember().getId());
        AnimalDTO oneAnimal = animalService.selectAnimal(saveTreatment.getAnimal().getId());
        DoctorDTO oneDoctor = doctorService.findOneDoctor(saveTreatment.getDoctor().getId());


        return new TreatmentDTO(saveTreatment.getId(), saveTreatment.getPurpose(), oneMember, oneAnimal, oneDoctor);
    }
}
