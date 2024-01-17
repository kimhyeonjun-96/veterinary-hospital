package com.myProject.treatment.domain.animal.dao;

import com.myProject.treatment.domain.animal.domain.Animal;
import com.myProject.treatment.domain.user.domain.Member;

import java.util.Optional;

public interface AnimalRepository {
    Animal save(Animal animal, Long memberId);

    Optional<Animal> findById(Long id);

    Optional<Animal> findByMemberId(String memberId);
}
