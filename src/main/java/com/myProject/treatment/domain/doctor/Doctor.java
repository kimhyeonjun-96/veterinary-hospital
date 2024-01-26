package com.myProject.treatment.domain.doctor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Doctor() {}

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

    // 수의사 비밀번호 변경
    public void updateDoctorPassword(String password){
        this.doctorPwd = password;
    }
    // 수의사 전화번호 변경
    public void updateDoctorPhone(String phone){
        this.doctorPhone = phone;
    }
}
