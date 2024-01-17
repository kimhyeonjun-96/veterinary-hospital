package com.myProject.treatment.domain.animal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String Name;
    private int Height;
    private int Weight;
    private Animal_type TYPE;
    private Long MemberID;

    public Animal() {}

    public Animal(String name, int height, int weight, Animal_type TYPE, Long memberID) {
        Name = name;
        Height = height;
        Weight = weight;
        this.TYPE = TYPE;
        MemberID = memberID;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getHeight() {
        return Height;
    }

    public int getWeight() {
        return Weight;
    }

    public Animal_type getTYPE() {
        return TYPE;
    }

    public Long getMemberID() {
        return MemberID;
    }
}
