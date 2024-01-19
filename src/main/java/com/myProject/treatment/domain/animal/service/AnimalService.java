package com.myProject.treatment.domain.animal.service;

import com.myProject.treatment.domain.animal.Animal;

import java.util.List;

public interface AnimalService {

    // 회원의 반려동물 등록
    public Animal regist(Animal animal, Long member_id);

    // 회원의 반려동물 리스트
    public List<Animal> getAnimal(Long memberId);

    // 회원의 특정 반려동물 정보
}
