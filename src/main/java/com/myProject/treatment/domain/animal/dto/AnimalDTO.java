package com.myProject.treatment.domain.animal.dto;

import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class AnimalDTO {

    private Long id;
    @NotEmpty(message = "아이의 이름은 필수 입니다.")
    private String name;
    private int height;
    private int weight;
    private String type;
    private Long memberId;

    public AnimalDTO() {}

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
