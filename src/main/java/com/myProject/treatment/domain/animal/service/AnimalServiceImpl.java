package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnimalServiceImpl{

    private final AnimalRepository animalRepository;
    private final MemberRepository memberRepository;


    /**
     * 회원 반려동물 등록
     * 회원 추가적인 반려동물 등록
     */
    @Transactional
    public AnimalDTO registAnimal(AnimalDTO aAnimalDTO, java.lang.Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Animal animal = new Animal(aAnimalDTO.getName(), aAnimalDTO.getHeight(), aAnimalDTO.getWeight(), aAnimalDTO.getType(),member.getId());
        Animal registerAnimal = animalRepository.saveAnimal(animal, memberId);

        return new AnimalDTO(registerAnimal.getId(), registerAnimal.getName(), registerAnimal.getHeight(), registerAnimal.getWeight(), registerAnimal.getType(), registerAnimal.getMemberId());
    }

    /**
     * 회원의 특정 반려동물 확인
     */
    public List<AnimalDTO> getAnimalList(java.lang.Long memberId) {
        List<Animal> animalList = animalRepository.findByMemberId(memberId);
        List<AnimalDTO> getAnimalListDTO = new ArrayList<>();

        for(Animal animal : animalList){
            getAnimalListDTO.add(new AnimalDTO(animal.getId(), animal.getName(), animal.getHeight(), animal.getWeight(), animal.getType(), animal.getMemberId()));
        }

        return getAnimalListDTO;
    }

    /**
     * 진료 받을 반려동물 선택
     */
    public AnimalDTO selectAnimal(java.lang.Long animalId) {
        return null;
    }
}
