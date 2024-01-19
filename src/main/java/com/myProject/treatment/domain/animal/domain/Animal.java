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
    private String type;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member MemberID;

    public Animal() {}

    public Animal(String name, int height, int weight, String type, Member memberID) {
        this.Name = name;
        this.Height = height;
        this.Weight = weight;
        this.type = type;
        this.MemberID = memberID;
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

    public String getTYPE() {
        return type;
    }

    public Member getMemberID() {
        return MemberID;
    }
}
