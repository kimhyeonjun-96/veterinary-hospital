package com.myProject.treatment.domain.reservation.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dao.ReservationRepository;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import com.myProject.treatment.domain.treatment.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final TreatmentService treatmentService;
    private final DoctorRepository doctorRepository;

    @Override
    public List<Reservation> getReservation(Long id) {
        return null;
    }

    @Override
    public ReservationDTO createReservation(Long memberId, TreatmentDTO treatmentDTO, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctor().getId()).get();

        // 선택한 시간 가능한지 확인
        if(checkReservationTime(doctor.getId(), selectStartTime, selectEndTime)){
            // 진료 정보 저장
            TreatmentDTO treatment = treatmentService.createTreatment(treatmentDTO);
        }
        // reservation_treatment 테이블에 진료, 예약 id 저장
        // reservation_treatment의 정보를 가지고 회원의 현재 진료 예약 신청 데이터 전달 ( 하나를 새롭게 만들어야 하나?? )
        return null;
    }

    @Override
    public boolean checkReservationTime(Long doctorId, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        // 수의사의 진료예약이 된 시간을 가져오기
        List<LocalDateTime> reservationTime = reservationRepository.findByDoctorIdReservationTime(doctorId);
        for(LocalDateTime time : reservationTime){
            System.out.println(time);
        }


        return false;
    }

    @Override
    public void completedReservation() {

    }

}
