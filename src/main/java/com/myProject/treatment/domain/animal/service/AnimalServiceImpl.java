package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.service.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService{

    private final AnimalRepository animalRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, MemberService memberService, MemberRepository memberRepository) {
        this.animalRepository = animalRepository;
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 반려동물 등록
     * 회원 추가적인 반려동물 등록
     */
    @Override
    public AnimalDTO registAnimal(AnimalDTO animalDTO, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Animal animal = new Animal(animalDTO.getName(), animalDTO.getHeight(), animalDTO.getWeight(), animalDTO.getType(),member);
        Animal registerAnimal = animalRepository.saveAnimal(animal, memberId);

        return new AnimalDTO(registerAnimal.getId(), registerAnimal.getName(), registerAnimal.getHeight(), registerAnimal.getWeight(), registerAnimal.getType(), registerAnimal.getMembers().getId());
    }

    /**
     * 회원의 특정 반려동물 확인
     */
    @Override
    public List<AnimalDTO> getAnimal(Long memberId) {
        List<Animal> animalList = animalRepository.findByMemberId(memberId);
        List<AnimalDTO> getAnimalListDTO = new ArrayList<>();

        for(Animal animal : animalList){
            getAnimalListDTO.add(new AnimalDTO(animal.getId(), animal.getName(), animal.getHeight(), animal.getWeight(), animal.getType(), animal.getMembers().getId()));
        }

        return getAnimalListDTO;
    }
}
