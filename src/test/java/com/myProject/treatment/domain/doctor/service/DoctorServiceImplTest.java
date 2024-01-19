package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class DoctorServiceImplTest {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    @Test
    public void 수의사_회록등록(){
        Doctor doctor = new Doctor("doc01", "doc01", "doc01", "010-9999-9999");

        Doctor joinDoctor = doctorService.join(doctor);

        assertThat(joinDoctor.getID()).isEqualTo(doctor.getID());
    }

    @Test
    public void 수의사_마이페이지(){
        Doctor doctor = doctorService.findOne(2L).get();

        assertThat(doctor.getDoctor_name()).isEqualTo("doc01");
    }
}