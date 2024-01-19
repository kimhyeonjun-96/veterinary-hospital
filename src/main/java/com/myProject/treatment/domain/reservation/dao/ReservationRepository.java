package com.myProject.treatment.domain.reservation.dao;

import com.myProject.treatment.domain.reservation.Reservation;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface ReservationRepository {

    Optional<Reservation> findById(Long id);


}
