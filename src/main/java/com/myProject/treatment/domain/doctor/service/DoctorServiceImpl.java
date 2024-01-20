package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
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
    public DoctorDTO signupDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getDoctorId(), doctorDTO.getDoctorPwd(), doctorDTO.getDoctorName(), doctorDTO.getDoctorPhone());

        validateDuplicateMember(doctor);
        doctorRepository.saveDoctor(doctor);
        return doctorDTO;
    }

    /**
     * 수의사 등록 시 중복 id 검증
     */
    @Override
    public void validateDuplicateMember(Doctor doctor) {
        doctorRepository.findByDoctorId(doctor.getDoctorId()).ifPresent(d -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 수의사 확인
     */
    @Override
    public DoctorDTO findOneDoctor(Map<String, Long> request) {
        Long doctorId = request.get("id");
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return new DoctorDTO(doctor.getId(), doctor.getDoctorId(), doctor.getDoctorPwd(), doctor.getDoctorName(), doctor.getDoctorPhone(), doctor.getTreatment(), doctor.getReservationList());
    }
}
