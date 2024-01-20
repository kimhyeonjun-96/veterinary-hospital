package com.myProject.treatment.domain.treatment;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.member.MemberDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String purpose;

    @OneToMany(mappedBy = "treatment")
    private List<MemberDTO> memberDTOS;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToMany(mappedBy = "treatment")
    private List<Doctor> doctors;
}
