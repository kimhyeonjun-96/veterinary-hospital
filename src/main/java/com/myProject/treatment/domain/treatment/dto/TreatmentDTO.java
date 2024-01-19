package com.myProject.treatment.domain.treatment.dto;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TreatmentDTO {
    private String purpose;

    private Member member;
    private Animal animal;
    private Doctor doctor;

    public TreatmentDTO() {}

    public TreatmentDTO(String purpose, Member member, Animal animal, Doctor doctor) {
        this.purpose = purpose;
        this.member = member;
        this.animal = animal;
        this.doctor = doctor;
    }
}
