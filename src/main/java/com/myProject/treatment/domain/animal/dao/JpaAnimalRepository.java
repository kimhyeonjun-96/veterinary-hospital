package com.myProject.treatment.domain.animal.dao;

import com.myProject.treatment.domain.animal.Animal;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaAnimalRepository implements AnimalRepository{
    private final EntityManager em;

    public JpaAnimalRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Animal saveAnimal(Animal animal, Long memberId) {
        em.persist(animal);

        return animal;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        Animal animal = em.find(Animal.class, id);
        return Optional.ofNullable(animal);
    }

    @Override
    public List<Animal> findByMemberId(Long memberId) {
        List<Animal> result = em.createQuery("select a from Animal a where a.MemberID = :memberId", Animal.class)
                .setParameter("memberId", memberId)
                .getResultList();

        return result;
    }
}
