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
    @PostMapping("/signup")
    public ResponseEntity<?> signupDoctor(@RequestBody DoctorDTO resource) throws URISyntaxException{
        DoctorDTO doc = doctorService.signupDoctor(resource);
        String url = "/doctor/" + doc.getId();
        return ResponseEntity.created(new URI(url)).body(doc.getDoctorName());
    }

    /**
     * 수의사 마이페이지
     */
    @PostMapping("/mypage")
    public ResponseEntity<?> mypage(@RequestBody Map<String, Long> request) throws URISyntaxException{
        DoctorDTO oneDoctor = doctorService.findOneDoctor(request);
        if (oneDoctor == null) return ResponseEntity.notFound().build();
        String url = "/doctor/mypage" + oneDoctor.getId();
        return ResponseEntity.ok(oneDoctor);
    }



}

