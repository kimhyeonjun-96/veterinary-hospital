package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    /**
     * 수의사 등록
     */
    @Override
    public Doctor join(Doctor doctor) {
        validateDuplicateMember(doctor);
        doctorRepository.save(doctor);

        return doctor;
    }


    /**
     * 수의사 등록 시 중복 id 검증
     */
    @Override
    public void validateDuplicateMember(Doctor doctor) {
        doctorRepository.findByDoctorId(doctor.getDoctor_id()).ifPresent(d -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Override
    public Optional<Doctor> findOne(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }
}
