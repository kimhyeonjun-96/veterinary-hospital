package com.myProject.treatment.domain.reservation;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private Long animalId;
    private Long doctorId;
    private Long treatmentId;

    public Reservation() {}

    public Reservation(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId, Long treatmentId) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animalId = animalId;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
    }

    public Reservation(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animalId = animalId;
        this.doctorId = doctorId;
    }

    public Reservation(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Long animalId, Long doctorId, Long treatmentId) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animalId = animalId;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
    }
}
