package com.myProject.treatment.domain.reservation.dao;

import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
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
    public List<ReservationDTO> findByDoctorIdReservationTime(Long doctorId) {
        return em.createQuery("SELECT r.reservationStartTime, r.reservationEndTime FROM Reservation r WHERE r.doctorId = :doctorId", ReservationDTO.class)
                .setParameter("doctorId", doctorId)
                .getResultList();
    }

    @Transactional
    @Override
    public Reservation saveTheReservation(Reservation reservation) {
        em.persist(reservation);
        return reservation;
    }

}
