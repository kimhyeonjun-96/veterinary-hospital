package com.myProject.treatment.domain.treatment;

import com.myProject.treatment.domain.doctor.Doctor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purpose;
    private Long memberId;
    private Long animalId;
    private Long doctorId;

    public Treatment() {}

    public Treatment(String purpose, Long memberId, Long animalId, Long doctorId) {
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }
    public Treatment(Long id, String purpose, Long memberId, Long animalId, Long doctorId) {
        this.id = id;
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }

}
