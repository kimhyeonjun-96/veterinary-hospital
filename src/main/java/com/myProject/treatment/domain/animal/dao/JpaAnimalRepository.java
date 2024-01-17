package com.myProject.treatment.domain.animal.dao;

import com.myProject.treatment.domain.animal.domain.Animal;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaAnimalRepository implements AnimalRepository{
    private final EntityManager em;

    public JpaAnimalRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Animal save(Animal animal, Long memberId) {
        em.persist(animal);

        return animal;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        Animal animal = em.find(Animal.class, id);
        return Optional.ofNullable(animal);
    }

    @Override
    public Optional<Animal> findByMemberId(String memberId) {
        List<Animal> result = em.createQuery("select a from Animal a where a.MemberID = :memberId", Animal.class)
                .setParameter("memberId", memberId)
                .getResultList();

        return result.stream().findAny();
    }
}
