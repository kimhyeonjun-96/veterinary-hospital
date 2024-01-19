package com.myProject.treatment.domain.reservation.service;

import com.myProject.treatment.domain.reservation.Reservation;

import java.util.List;

public interface ReservationService {
    // 예약 확인
    List<Reservation> getReservation(Long memberId);

    // 예약 생성

    // 예약 취소
}
