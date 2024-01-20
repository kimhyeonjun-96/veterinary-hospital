package com.myProject.treatment.domain.reservation.dao;

import com.myProject.treatment.domain.reservation.Reservation;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Optional<Reservation> findById(Long id);

    List<LocalDateTime> findByDoctorIdReservationTime(Long doctorId);
}
