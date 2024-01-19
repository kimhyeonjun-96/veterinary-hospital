package com.myProject.treatment.domain.doctor.controller;

import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    /**
     * 수의사 등록
     */
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DoctorDTO resource) throws URISyntaxException{
        Doctor doc = doctorService.join(new Doctor(resource.getDoctor_id(), resource.getDoctor_pwd(), resource.getDoctor_name(), resource.getDoctor_phone()));
        String url = "/doctor/" + doc.getID();

        return ResponseEntity.created(new URI(url)).body(doc.getDoctor_name());
    }

    /**
     * 수의사 마이페이지
     */
    @PostMapping("/mypage")
    public ResponseEntity<?> mypage(@RequestBody Map<String, Long> request) throws URISyntaxException{
        Long id = request.get("id");
        Doctor doctor = doctorService.findOne(id).orElse(null);

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        String url = "/doctor/mypage" + doctor.getID();

        return ResponseEntity.ok(doctor);
    }



}

