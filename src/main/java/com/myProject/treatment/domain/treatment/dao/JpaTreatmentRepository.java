package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.member.dto.MemberTreatmentHistoryDTO;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaTreatmentRepository implements TreatmentRepository{

    private final EntityManager em;
    public JpaTreatmentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public Treatment saveTreatment(Treatment treatment) {
        em.persist(treatment);
        return treatment;
    }

    @Override
    public List<MemberTreatmentHistoryDTO> findTreatmentListByMemberId(Long memberId) {
        String jpql = "SELECT t.id, t.purpose" +
                ", m.memberName, m.memberPhone" +
                ", a.name" +
                ", r.reservationStartTime, r.reservationEndTime" +
                ", d.doctorName FROM Treatment t" +
                " JOIN Member m ON m.id = t.memberId" +
                " JOIN Animal a ON a.id = t.animalId" +
                " JOIN Reservation r ON r.treatmentId = t.id" +
                " JOIN Doctor d ON d.id = t.doctorId" +
                " WHERE m.id = :memberId";

        Query query = em.createQuery(jpql, MemberTreatmentHistoryDTO.class);
        query.setParameter("memberId", memberId);

        return query.getResultList();
    }
}
