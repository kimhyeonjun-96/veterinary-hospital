package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;

import java.util.Map;
import java.util.Optional;

public interface DoctorService {
    public DoctorDTO signupDoctor(DoctorDTO doctorDTO);

    public void validateDuplicateMember(Doctor doctor);

    public DoctorDTO findOneDoctor(Map<String, Long> request);
}
