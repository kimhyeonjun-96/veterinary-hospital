package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorTreatmentHistoryDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorTodayTreatmentScheduleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DoctorServiceImpl{

    private final DoctorRepository doctorRepository;
    private final AnimalRepository animalRepository;
    private final TreatmentRepository treatmentRepository;

    /**
     * 수의사 등록
     */
    @Transactional
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
     * 의사의 정보 수정
     */
    @Transactional
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).get();
        doctor.updateDoctorPassword(doctorDTO.getDoctorPwd());
        doctor.updateDoctorPhone(doctorDTO.getDoctorPhone());

        Doctor updateDoctor = doctorRepository.saveDoctor(doctor);
        return new DoctorDTO(updateDoctor.getId(), updateDoctor.getDoctorId(), updateDoctor.getDoctorPwd(), updateDoctor.getDoctorName(), updateDoctor.getDoctorPhone());
    }

    /**
     * 수의사의 오늘 진료들 확인
     */
    public List<DoctorTodayTreatmentScheduleDTO> getDoctorTodaySchedule(Long id){
        return treatmentRepository.findTodayTreatmentListByDoctorId(id);
    }

    /**
     * 의사 전체 진료 내역 확인
     */
    public List<DoctorTreatmentHistoryDTO> getAllTreatmentRecordsForDoctor(Long id) {
        return treatmentRepository.findTreatmentListByDoctorId(id);
    }

    /**
     * 의사 진료 후 반려 동물 전보 업데이트
     */
    @Transactional
    public AnimalDTO updateAnimalInfoAfterTreatment(Long doctorId, Long treatmentId, AnimalDTO animalDTO) {
        Animal animal = animalRepository.findByDoctorIdAndTreatmentId(doctorId, treatmentId).get();
        animal.updateAnimalHeight(animalDTO.getHeight());
        animal.updateAnimalWeight(animalDTO.getWeight());

        Animal updateAnimal = animalRepository.saveAnimal(animal, animal.getMemberId());
        return new AnimalDTO(updateAnimal.getId(), updateAnimal.getName(), updateAnimal.getHeight(), updateAnimal.getWeight(), updateAnimal.getType(), updateAnimal.getMemberId());
    }
}


