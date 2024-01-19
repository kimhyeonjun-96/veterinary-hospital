package com.myProject.treatment.domain.reservation.controller;

import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * 예약 목록 확인
     */
    @GetMapping("/reservation")
    public List<Reservation> list(@RequestParam Long memberId){
        List<Reservation> reservation = reservationService.getReservation(memberId);

        return reservation;
    }
}
