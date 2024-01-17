package com.myProject.treatment.domain.animal.domain;

import com.myProject.treatment.domain.user.domain.Member;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String Name;
    private int Height;
    private int Weight;
    private Animal_type TYPE;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member MemberID;

    public Animal() {}

    public Animal(String name, int height, int weight, Animal_type TYPE, Member memberID) {
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

    public Member getMemberID() {
        return MemberID;
    }
}
