package com.myProject.treatment.domain.animal.dto;

import com.myProject.treatment.domain.member.Member;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnimalDTO {

    @NotEmpty(message = "아이의 이름은 필수 입니다.")
    private String Name;
    private int Height;
    private int Weight;
    private String TYPE;

    private Member member;
}
