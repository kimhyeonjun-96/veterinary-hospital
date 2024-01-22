package com.myProject.treatment.domain.reservation.dto;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.treatment.Treatment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private Long animal;
    private Long doctor;
    private List<Long> treatments;

    public ReservationDTO(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
    }

    public ReservationDTO(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animal, Long doctor) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
    }

    public ReservationDTO(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId, List<Long> treatments) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animalId;
        this.doctor = doctorId;
        this.treatments = treatments;
    }
}
