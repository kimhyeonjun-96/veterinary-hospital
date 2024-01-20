package com.myProject.treatment.domain.reservation.service;

import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    // 예약 확인
    public List<Reservation> getReservation(Long id);

    // 예약 신청 프로세스
    // 01. 회원정보에 대하여 저장
    // 02. 의사 선택
    // 03. 가능한 시간 선택( 기본 진료시간 : 진료코드에 따라 값을 다르게? )
    // 04. 에약 신청 완료
    // 회원 진료 예약
    public ReservationDTO createReservation(Long memberId, TreatmentDTO treatmentDTO, LocalDateTime selectStartTime, LocalDateTime selectEndTime);

    public boolean checkReservationTime(Long doctorId, LocalDateTime selectStartTime, LocalDateTime selectEndTime);

    public void completedReservation();


    // 예약 취소
}
