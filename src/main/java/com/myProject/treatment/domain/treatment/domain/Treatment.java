package com.myProject.treatment.domain.treatment.domain;

import com.myProject.treatment.domain.user.domain.Member;
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
