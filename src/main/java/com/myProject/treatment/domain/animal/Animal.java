package com.myProject.treatment.domain.animal;

import com.myProject.treatment.domain.member.Member;
import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String Name;
    private int Height;
    private int Weight;
    private String type;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member members;

    public Animal() {}

    public Animal(String name, int height, int weight, String type, Member member) {
        this.Name = name;
        this.Height = height;
        this.Weight = weight;
        this.type = type;
        this.members = member;
    }

    public Long getID() {
        return this.ID;
    }

    public String getName() {
        return this.Name;
    }

    public int getHeight() {
        return this.Height;
    }

    public int getWeight() {
        return this.Weight;
    }

    public String getTYPE() {
        return this.type;
    }

    public String getType() {
        return type;
    }

    public Member getMembers() {
        return members;
    }
}
