package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class DoctorServiceImplTest {
    @Autowired private DoctorServiceImpl doctorService;
    @Autowired private DoctorRepository doctorRepository;

    @Test
    public void 수의사_회록등록(){
        DoctorDTO aDoctorDTO = new DoctorDTO("doc02", "doc02", "doc02", "010-8888-8888");

        DoctorDTO joinDoctor = doctorService.signupDoctor(aDoctorDTO);
        assertThat(joinDoctor.getDoctorId()).isEqualTo(aDoctorDTO.getDoctorId());
    }

    @Test
    public void 수의사_마이페이지(){
        DoctorDTO aDoctorDTO = doctorService.findOneDoctor(8L);

        assertThat(aDoctorDTO.getDoctorName()).isEqualTo("doc02");
    }
}