package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.service.AnimalService;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.service.MemberService;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Member member = memberRepository.findById(treatmentDTO.getMemberId()).get();
        Animal animal = animalRepository.findById(treatmentDTO.getAnimalId()).get();
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctorId()).get();

        Treatment saveTreatment = treatmentRepository.saveTreatment(new Treatment(treatmentDTO.getPurpose(), member, animal, doctor));

        return new TreatmentDTO(saveTreatment.getId(), saveTreatment.getPurpose(), treatmentDTO.getMemberId(), treatmentDTO.getAnimalId(), treatmentDTO.getDoctorId());
    }
}
