package com.myProject.treatment.domain.reservation;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private Long treatmentId;

    public Reservation(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Animal animal, Doctor doctor, Long treatmentId) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
        this.treatmentId = treatmentId;
    }

    public Reservation(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Animal animal, Doctor doctorId) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
    }

    public Reservation(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Animal animal, Doctor doctor, Long treatmentId) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
        this.treatmentId = treatmentId;
    }
}
