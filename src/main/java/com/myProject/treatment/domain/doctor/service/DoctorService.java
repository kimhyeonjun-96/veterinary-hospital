package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;

import java.util.Optional;

public interface DoctorService {
    public Doctor join(Doctor doctor);

    public void validateDuplicateMember(Doctor doctor);

    public Optional<Doctor> findOne(Long doctorId);
}
