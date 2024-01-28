package com.myProject.treatment.domain.doctor.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DoctorTodayTreatmentScheduleDTO {

    private String doctorName;
    private String doctorPhone;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private String memberName;
    private String memberPhone;
    private String address;
    private String animalName;
    private Integer animalHeight;
    private Integer animalWeight;
    private String animalType;
    private String purpose;

    public DoctorTodayTreatmentScheduleDTO(String doctorName, String doctorPhone, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, String memberName, String memberPhone, String address, String animalName, Integer animalHeight, Integer animalWeight, String animalType, String purpose) {
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.address = address;
        this.animalName = animalName;
        this.animalHeight = animalHeight;
        this.animalWeight = animalWeight;
        this.animalType = animalType;
        this.purpose = purpose;
    }
}
