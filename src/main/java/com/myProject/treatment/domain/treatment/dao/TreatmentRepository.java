package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.treatment.Treatment;

public interface TreatmentRepository {
    Treatment save(Treatment treatment);
}
