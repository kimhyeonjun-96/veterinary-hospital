package com.myProject.treatment.domain.doctor;

import com.myProject.treatment.domain.treatment.Treatment;
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

    public Doctor() {}

    public Doctor(String doctor_id, String doctor_pwd, String doctor_name, String doctor_phone) {
        this.doctor_id = doctor_id;
        this.doctor_pwd = doctor_pwd;
        this.doctor_name = doctor_name;
        this.doctor_phone = doctor_phone;
    }

    public Long getID() {
        return ID;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getDoctor_pwd() {
        return doctor_pwd;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public Treatment getTreament() {
        return treament;
    }
}
