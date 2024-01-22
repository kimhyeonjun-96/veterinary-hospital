package com.myProject.treatment.domain.treatment.dto;

import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import lombok.Getter;

@Getter
public class TreatmentDTO {

    private Long id;
    private String purpose;

    private Long memberId;
    private Long animalId;
    private Long doctorId;

    public TreatmentDTO() {}

    public TreatmentDTO(String purpose, Long memberId, Long animalId, Long doctorId) {
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }

    public TreatmentDTO(String purpose, Long animalId, Long doctorId) {
        this.purpose = purpose;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }

    public TreatmentDTO(Long id, String purpose, Long memberId, Long animalId, Long doctorId) {
        this.id = id;
        this.purpose = purpose;
        this.memberId = memberId;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }
}
