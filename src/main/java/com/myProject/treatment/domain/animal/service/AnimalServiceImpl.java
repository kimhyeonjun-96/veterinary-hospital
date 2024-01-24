package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnimalServiceImpl{

    private final AnimalRepository animalRepository;
    private final MemberRepository memberRepository;


    /**
     * 회원 반려동물 등록
     * 회원 추가적인 반려동물 등록
     */
    public AnimalDTO registAnimal(AnimalDTO aAnimalDTO, java.lang.Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Animal animal = new Animal(aAnimalDTO.getName(), aAnimalDTO.getHeight(), aAnimalDTO.getWeight(), aAnimalDTO.getType(),member);
        Animal registerAnimal = animalRepository.saveAnimal(animal, memberId);

        return new AnimalDTO(registerAnimal.getId(), registerAnimal.getName(), registerAnimal.getHeight(), registerAnimal.getWeight(), registerAnimal.getType(), registerAnimal.getMembers().getId());
    }

    /**
     * 회원의 특정 반려동물 확인
     */
    public List<AnimalDTO> getAnimalList(java.lang.Long memberId) {
        List<Animal> animalList = animalRepository.findByMemberId(memberId);
        List<AnimalDTO> getAnimalListDTO = new ArrayList<>();

        for(Animal animal : animalList){
            getAnimalListDTO.add(new AnimalDTO(animal.getId(), animal.getName(), animal.getHeight(), animal.getWeight(), animal.getType(), animal.getMembers().getId()));
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
