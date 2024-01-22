package com.myProject.treatment.domain.reservation.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private Long animalId;
    private Long doctorId;
    private Long treatmentId;

    public ReservationDTO(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
    }

    public ReservationDTO(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }

    public ReservationDTO(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId, Long treatmentId) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animalId = animalId;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
    }
}
