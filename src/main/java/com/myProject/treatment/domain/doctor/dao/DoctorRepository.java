package com.myProject.treatment.domain.doctor.dao;

import com.myProject.treatment.domain.doctor.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    Doctor saveDoctor(Doctor doctor);

    Optional<Doctor> findById(Long id);

    Optional<Doctor> findByDoctorId(String doctorId);

    List<Doctor> findAllDoctor();
}
