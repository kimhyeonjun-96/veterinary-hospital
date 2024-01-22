package com.myProject.treatment.domain.reservation;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    @ManyToMany
    @JoinTable(
            name = "reservation_treatment",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private List<Treatment> treatments;

    public Reservation(Long id, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Animal animal, Doctor doctor, List<Treatment> treatments) {
        this.id = id;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
        this.treatments = treatments;
    }

    public Reservation(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, Animal animal, Doctor doctor) {
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.animal = animal;
        this.doctor = doctor;
    }
}
