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
    private double height;
    private double weight;
    private String type;
    private Long memberId;

    public Animal() {}

    public Animal(String name, double height, double weight, String type, Long memberId) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }

    public Animal(Long id, String name, double height, double weight, String type, Long memberId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.memberId = memberId;
    }

    // 진료 후 동물의 키 변경
    public void updateAnimalHeight(double height){
        this.height = height;
    }

    // 진료 후 동물의 무게 변경
    public void updateAnimalWeight(double weight){
        this.weight = weight;
    }
}
