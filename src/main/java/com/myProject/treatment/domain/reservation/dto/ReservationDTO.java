package com.myProject.treatment.domain.reservation.dto;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.treatment.Treatment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private Animal animal;
    private Doctor doctor;
    private List<Treatment> treatments;

    public ReservationDTO() {}
}
