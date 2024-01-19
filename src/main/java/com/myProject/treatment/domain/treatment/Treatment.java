package com.myProject.treatment.domain.treatment;

import com.myProject.treatment.domain.member.Member;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToMany(mappedBy = "treatment")
    private List<Member> members;
}
