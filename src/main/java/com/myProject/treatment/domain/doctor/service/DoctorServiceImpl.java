package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorTreatmentHistoryDTO;
import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl{

    private final DoctorRepository doctorRepository;
    private final TreatmentRepository treatmentRepository;

    /**
     * 수의사 등록
     */
    public DoctorDTO signupDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getDoctorId(), doctorDTO.getDoctorPwd(), doctorDTO.getDoctorName(), doctorDTO.getDoctorPhone());
        validateDuplicateMember(doctor);

        Doctor joinDoctor = doctorRepository.saveDoctor(doctor);
        return new DoctorDTO(joinDoctor.getId(), joinDoctor.getDoctorId(), joinDoctor.getDoctorPwd(), joinDoctor.getDoctorName(), joinDoctor.getDoctorPhone());
    }

    /**
     * 수의사 등록 시 중복 id 검증
     */
    public void validateDuplicateMember(Doctor doctor) {
        doctorRepository.findByDoctorId(doctor.getDoctorId()).ifPresent(d -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 수의사 확인
     */
    public DoctorDTO findOneDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
//        List<Treatment> treatmentList = doctor.getTreatmentId();
//        List<Reservation> reservationList = doctor.getReservationId();

        return new DoctorDTO(doctor.getId(), doctor.getDoctorId(), doctor.getDoctorPwd(), doctor.getDoctorName(), doctor.getDoctorPhone());
    }

    /**
     * 모든 수의사 확인
     */
    public List<DoctorDTO> findAllDoctor() {
        List<Doctor> allDoctor = doctorRepository.findAllDoctor();
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for(Doctor doctor : allDoctor) {
            doctorDTOList.add(new DoctorDTO(doctor.getId(), doctor.getDoctorId(), doctor.getDoctorPwd(), doctor.getDoctorName(), doctor.getDoctorPhone()));
        }
        return doctorDTOList;
    }

    /**
     * 특정 의사에게 진료 추가
     */
    public DoctorDTO addTreamentToDoctor(Long doctorId, Long treatmentId) {

        return null;
    }

    /**
     * 의사의 정보 수정
     */
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).get();
        doctor.updateDoctorPassword(doctorDTO.getDoctorPwd());
        doctor.updateDoctorPhone(doctorDTO.getDoctorPhone());

        Doctor updateDoctor = doctorRepository.saveDoctor(doctor);
        return new DoctorDTO(updateDoctor.getId(), updateDoctor.getDoctorId(), updateDoctor.getDoctorPwd(), updateDoctor.getDoctorName(), updateDoctor.getDoctorPhone());
    }

    /**
     * 의사 전체 진료 내역 확인
     */
    public List<DoctorTreatmentHistoryDTO> getAllTreatmentRecordsForDoctor(Long id){
        return treatmentRepository.findTreatmentListByDoctorId(id);
    }

}
