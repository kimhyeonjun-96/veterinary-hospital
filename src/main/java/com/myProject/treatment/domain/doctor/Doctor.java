package com.myProject.treatment.domain.doctor;

import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorId;
    private String doctorPwd;
    private String doctorName;
    private String doctorPhone;

    @OneToMany(mappedBy = "doctor")
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservations;

    public Doctor(String doctorId, String doctorPwd, String doctorName, String doctor_phone) {
        this.doctorId = doctorId;
        this.doctorPwd = doctorPwd;
        this.doctorName = doctorName;
        this.doctorPhone = doctor_phone;
    }


}
