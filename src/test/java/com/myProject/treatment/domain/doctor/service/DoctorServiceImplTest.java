package com.myProject.treatment.domain.doctor.service;

import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class DoctorServiceImplTest {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    @Test
    public void 수의사_회록등록(){
        DoctorDTO doctorDTO = new DoctorDTO("doc01", "doc01", "doc01", "010-9999-9999");

        DoctorDTO joinDoctor = doctorService.signupDoctor(doctorDTO);

        assertThat(joinDoctor.getId()).isEqualTo(doctorDTO.getId());
    }

    @Test
    public void 수의사_마이페이지(){
        HashMap<String, Long> map = new HashMap<>();
        map.put("id", 2L);

        DoctorDTO doctorDTO = doctorService.findOneDoctor(map);

        assertThat(doctorDTO.getDoctorName()).isEqualTo("doc01");
    }
}