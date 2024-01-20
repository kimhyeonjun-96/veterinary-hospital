package com.myProject.treatment.domain.treatment.dto;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TreatmentDTO {

    private Long id;
    private String purpose;

    private MemberDTO memberDTO;
    private AnimalDTO animal;
    private DoctorDTO doctor;

    public TreatmentDTO() {}

    public TreatmentDTO(String purpose, MemberDTO memberDTO, AnimalDTO animal, DoctorDTO doctor) {
        this.purpose = purpose;
        this.memberDTO = memberDTO;
        this.animal = animal;
        this.doctor = doctor;
    }

    public TreatmentDTO(String purpose,  AnimalDTO animal, DoctorDTO doctor) {
        this.purpose = purpose;
        this.animal = animal;
        this.doctor = doctor;
    }

    public TreatmentDTO(Long id, String purpose, MemberDTO memberDTO, AnimalDTO animal, DoctorDTO doctor) {
        this.id = id;
        this.purpose = purpose;
        this.memberDTO = memberDTO;
        this.animal = animal;
        this.doctor = doctor;
    }
}
