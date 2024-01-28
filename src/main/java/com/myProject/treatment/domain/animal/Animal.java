package com.myProject.treatment.domain.animal;

import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.treatment.Treatment;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int height;
    private int weight;
    private String type;
    private Long memberId;

    public Animal() {}

    public Animal(String name, int height, int weight, String type, Long memberId) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }

    public Animal(Long id, String name, int height, int weight, String type, Long memberId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }
}
