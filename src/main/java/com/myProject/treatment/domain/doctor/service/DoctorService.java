package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    // 수의사 회원가입
    public DoctorDTO signupDoctor(DoctorDTO aDoctorDTO);

    // 수의사 아이디 중복 검사
    public void validateDuplicateMember(Doctor doctor);

    // 특정 수의사 상세 조회
    public DoctorDTO findOneDoctor(Long doctorId);

    // 모든 수의사 조회
    public List<DoctorDTO> findAllDoctor();

    // 수의사 진료예약 시간들

}
