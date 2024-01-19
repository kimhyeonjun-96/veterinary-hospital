package com.myProject.treatment.domain.doctor.dto;

import com.myProject.treatment.domain.treatment.domain.Treatment;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DoctorDTO {
    @NotEmpty(message = "수의사님 아이디는 필수 입니다.")
    private String doctor_id;
    private String doctor_pwd;

    @NotEmpty(message = "수의사님 이름은 필수 입니다.")
    private String doctor_name;
    private String doctor_phone;


    private Treatment treatment;
}
