package com.myProject.treatment.domain.animal.dao;

import com.myProject.treatment.domain.animal.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal save(Animal animal, Long memberId);

    Optional<Animal> findById(Long id);

    List<Animal> findByMemberId(Long memberId);
}
