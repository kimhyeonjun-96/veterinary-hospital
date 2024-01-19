package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.Animal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService{
    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /**
     * 회원 반려동물 등록
     * 회원 추가적인 반려동물 등록
     */
    @Override
    public Animal regist(Animal animal, Long member_id) {
        animalRepository.save(animal, member_id);

        return animal;
    }
}
