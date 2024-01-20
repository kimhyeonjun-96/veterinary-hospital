package com.myProject.treatment.domain.reservation;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private LocalDateTime reservation_time;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToMany(mappedBy = "reservation")
    private List<Doctor> doctors;

    @ManyToMany(mappedBy = "treatment")
    private List<Treatment> treatments;




}
