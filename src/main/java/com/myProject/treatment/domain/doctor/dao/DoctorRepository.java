package com.myProject.treatment.domain.doctor.dao;

import com.myProject.treatment.domain.doctor.Doctor;

import java.util.Optional;

public interface DoctorRepository {
    Doctor saveDoctor(Doctor doctor);

    Optional<Doctor> findById(Long id);

    Optional<Doctor> findByDoctorId(String doctorId);
}
