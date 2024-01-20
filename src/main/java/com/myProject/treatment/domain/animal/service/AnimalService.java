package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;

import java.util.List;

public interface AnimalService {

    // 회원의 반려동물 등록
    public AnimalDTO registAnimal(AnimalDTO animalDTO, Long memberId);

    // 회원의 반려동물 리스트
    public List<AnimalDTO> getAnimalList(Long memberId);

    // 회원의 특정 반려동물 선택
    public AnimalDTO selectAnimal(Long animalId);
}
