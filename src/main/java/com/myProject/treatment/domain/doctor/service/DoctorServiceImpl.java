package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    /**
     * 수의사 등록
     */
    @Override
    public DoctorDTO signupDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getDoctorId(), doctorDTO.getDoctorPwd(), doctorDTO.getDoctorName(), doctorDTO.getDoctorPhone());
        validateDuplicateMember(doctor);

        Doctor joinDoctor = doctorRepository.saveDoctor(doctor);
        return new DoctorDTO(joinDoctor.getId(), joinDoctor.getDoctorId(), joinDoctor.getDoctorPwd(), joinDoctor.getDoctorName(), joinDoctor.getDoctorPhone());
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
    public DoctorDTO findOneDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return new DoctorDTO(doctor.getId(), doctor.getDoctorId(), doctor.getDoctorPwd(), doctor.getDoctorName(), doctor.getDoctorPhone(), doctor.getTreatment(), doctor.getReservationList());
    }

    /**
     * 모든 수의사 확인
     */
    @Override
    public List<DoctorDTO> findAllDoctor() {
        List<Doctor> allDoctor = doctorRepository.findAllDoctor();
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for(Doctor doctor : allDoctor) {
            doctorDTOList.add(new DoctorDTO(doctor.getId(), doctor.getDoctorId(), doctor.getDoctorPwd(), doctor.getDoctorName(), doctor.getDoctorPhone(), doctor.getTreatment(), doctor.getReservationList()));
        }
        return doctorDTOList;
    }

    /**
     * 예약된 진료 시간 리스트
     */
}
