package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{


    @Override
    public Doctor join(Doctor doctor) {
        return null;
    }

    @Override
    public void validateDuplicateMember(Doctor doctor) {

    }

    @Override
    public Optional<Doctor> findOne(Long doctorId) {
        return Optional.empty();
    }
}
