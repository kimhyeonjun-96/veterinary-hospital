package com.myProject.treatment.domain.reservation.dao;

import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.Tuple;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    public Optional<Reservation> findById(Long id);

    public List<ReservationDTO> findByDoctorIdReservationTime(Long doctorId);

    public Reservation saveTheReservation(Reservation reservation);

    // 진료별 예약 확인
    public List<Reservation> findReservationByTreatmentId(Long treatmentId);

}
