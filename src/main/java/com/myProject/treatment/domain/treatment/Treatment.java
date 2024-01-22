package com.myProject.treatment.domain.treatment;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purpose;
    private Long memberId;
    private Long animalId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    public Treatment(String purpose, Long memberId, Long animalId, Doctor doctor) {
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctor = doctor;
    }
    public Treatment(Long id, String purpose, Long memberId, Long animalId, Doctor doctor) {
        this.id = id;
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctor = doctor;
    }
}
