package com.myProject.treatment.domain.doctor.dto;

import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class DoctorDTO {

    private Long id;
    @NotEmpty(message = "수의사님 아이디는 필수 입니다.")
    private String doctorId;
    private String doctorPwd;
    @NotEmpty(message = "수의사님 이름은 필수 입니다.")
    private String doctorName;
    private String doctorPhone;

    public DoctorDTO() {}

    public DoctorDTO(String doctorId, String doctorPwd, String doctorName, String doctorPhone) {
        this.doctorId = doctorId;
        this.doctorPwd = doctorPwd;
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
    }

    public DoctorDTO(Long id, String doctorId, String doctorPwd, String doctorName, String doctorPhone) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorPwd = doctorPwd;
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
    }
}
