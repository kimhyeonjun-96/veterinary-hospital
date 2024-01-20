package com.myProject.treatment.domain.reservation.dao;

import com.myProject.treatment.domain.reservation.Reservation;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class JpaReservationRepository implements ReservationRepository{

    private final EntityManager em;

    public JpaReservationRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        Reservation reservation = em.find(Reservation.class, id);

        return Optional.ofNullable(reservation);
    }

    @Override
    public List<LocalDateTime> findByDoctorIdReservationTime(Long doctorId) {
       return em.createQuery("select r.reservationStartTime, r.reservationEndTime from Reservation r where r.doctor.id = :doctorId", LocalDateTime.class)
                .setParameter("doctorId", doctorId)
                .getResultList();
    }
}
