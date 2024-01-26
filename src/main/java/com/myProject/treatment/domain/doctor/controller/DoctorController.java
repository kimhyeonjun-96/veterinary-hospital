package com.myProject.treatment.domain.doctor.controller;

import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServiceImpl doctorService;

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
    @PostMapping("/{id}/mypage")
    public ResponseEntity<?> mypage(@PathVariable java.lang.Long id) {
        DoctorDTO oneDoctor = doctorService.findOneDoctor(id);
        if (oneDoctor == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(oneDoctor);
    }

    /**
     * 수의사 정보 수정
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateDoctorInfo(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) throws URISyntaxException {
        DoctorDTO updateDoctor = doctorService.updateDoctor(id, doctorDTO);
        String url = "/doctor/" + updateDoctor.getId();
        if(updateDoctor != null){
            return ResponseEntity.created(new URI(url)).body(updateDoctor);
        }else{
            return ResponseEntity.created(new URI(url)).body("정보 업데이트를 하지 못 했습니다.");
        }
    }


}

