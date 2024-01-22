package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
