package com.myProject.treatment.domain.reservation.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.service.DoctorServiceImpl;
import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dao.ReservationRepository;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import com.myProject.treatment.domain.treatment.service.TreatmentServiceImpl;
import com.myProject.treatment.exception.ReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl{

    private final ReservationRepository reservationRepository;
    private final AnimalRepository animalRepository;
    private final DoctorRepository doctorRepository;
    private final TreatmentServiceImpl treatmentService;
    private final DoctorServiceImpl doctorService;

    public ReservationDTO createReservation(Long memberId, TreatmentDTO treatmentDTO, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctorId()).get(); // 선택된 의사 가져오기

        if(checkReservationTime(doctor.getId(), selectStartTime, selectEndTime)){ // 선택한 시간 가능한지 확인
            Treatment saveTreatment = treatmentService.createTreatment(memberId, treatmentDTO); // 진료 정보 저장
            Animal animal = animalRepository.findById(saveTreatment.getAnimalId()).get(); // 예약 정보 저장을 위한 반려동물 데이터
            Reservation reservation = reservationRepository.saveTheReservation(new Reservation(selectStartTime, selectEndTime, animal.getId(), doctor.getId(), saveTreatment.getId()));
            doctorService.addTreamentToDoctor(doctor.getId(), saveTreatment.getId());
            return new ReservationDTO(reservation.getId(), reservation.getReservationStartTime(), reservation.getReservationEndTime(), reservation.getAnimalId(), reservation.getDoctorId(), reservation.getTreatmentId());
        }else{
            throw new ReservationException("이미 예약된 시간입니다.");
        }
    }

    public boolean checkReservationTime(Long doctorId, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        // 수의사의 진료예약이 된 시간을 가져오기
        List<ReservationDTO> reservationTimeDTOList = reservationRepository.findByDoctorIdReservationTime(doctorId);
        selectStartTime = typeConversion(selectStartTime);

        for(ReservationDTO reservationDTO : reservationTimeDTOList){
            LocalDateTime existingTime = typeConversion(reservationDTO.getReservationStartTime());
            if(existingTime.equals(selectStartTime)){
                return false;
            }
        }
        return true;
    }

    private LocalDateTime typeConversion(LocalDateTime time){
        DateTimeFormatter coversionTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strTime = time.format(coversionTime);
        return LocalDateTime.parse(strTime, coversionTime);
    }

}
