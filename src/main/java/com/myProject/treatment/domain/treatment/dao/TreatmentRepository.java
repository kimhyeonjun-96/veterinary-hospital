package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.treatment.Treatment;

public interface TreatmentRepository {
    Treatment saveTreatment(Treatment treatment);
}
