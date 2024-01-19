package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dao.TreatmentRepository;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService{

    private final TreatmentRepository treatmentRepository;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Treatment createTreatment(Treatment treatment) {
        return null;
    }
}
