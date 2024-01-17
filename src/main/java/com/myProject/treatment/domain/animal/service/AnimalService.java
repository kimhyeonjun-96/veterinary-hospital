package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.domain.Animal;

public interface AnimalService {

    public Long regist(Animal animal, Long member_id);
}
