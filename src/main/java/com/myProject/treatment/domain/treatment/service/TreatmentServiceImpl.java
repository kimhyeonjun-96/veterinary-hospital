package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TreatmentServiceImpl{

    private final TreatmentRepository treatmentRepository;
    private final MemberRepository memberRepository;
    private final AnimalRepository animalRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Treatment createTreatment(Long memberId, TreatmentDTO treatmentDTO) {
        Member member = memberRepository.findById(memberId).get();
        Animal animal = animalRepository.findById(treatmentDTO.getAnimalId()).get();
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctorId()).get();
        return treatmentRepository.saveTreatment(new Treatment(treatmentDTO.getPurpose(), member.getId(), animal.getId(), doctor.getId()));
    }
}
