package com.myProject.treatment.domain.doctor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
    private Long treatmentId;
    private Long reservationId;

    public Doctor(String doctorId, String doctorPwd, String doctorName, String doctor_phone) {
        this.doctorId = doctorId;
        this.doctorPwd = doctorPwd;
        this.doctorName = doctorName;
        this.doctorPhone = doctor_phone;
    }


}
