package com.myProject.treatment.domain.animal.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AnimalDTO {

    private Long id;
    @NotEmpty(message = "아이의 이름은 필수 입니다.")
    private String name;
    private int height;
    private int weight;
    private String type;
    private Long memberId;

    public AnimalDTO(String name, int height, int weight, String type, Long memberId) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }

    public AnimalDTO(Long id, String name, int height, int weight, String type, Long memberId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }
}
