package com.myProject.treatment.domain.doctor;

import com.myProject.treatment.domain.treatment.domain.Treatment;
import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String doctor_id;
    private String doctor_pwd;
    private String doctor_name;
    private String doctor_phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private Treatment treament;

}
