package com.myProject.treatment.domain.doctor.controller;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorTreatmentHistoryDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorTodayTreatmentScheduleDTO;
import com.myProject.treatment.domain.doctor.service.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

    /**
     * 진료 후 반려동물 정보 업데이트
     */
    @PutMapping("/{doctorId}/treatment/{treatmentId}/update-pet-info")
    public ResponseEntity<?> updatePetInfoAfterTreatment(
            @PathVariable Long doctorId,
            @PathVariable Long treatmentId,
            @RequestBody AnimalDTO animalDTO
            ) throws URISyntaxException {
        AnimalDTO updateAnimal = doctorService.updateAnimalInfoAfterTreatment(doctorId, treatmentId, animalDTO);
        String url = "/doctor/" +doctorId + "/treatment/" + updateAnimal.getId();

        if(updateAnimal != null){
            return ResponseEntity.created(new URI(url)).body(updateAnimal);
        }else{
            return ResponseEntity.created(new URI(url)).body("정보 업데이트를 하지 못 했습니다.");
        }
    }

    /**
     * 수의사의 모든 진료내역들 확인
     */
    @GetMapping("/{id}/mypage/getTreamentList")
    public ResponseEntity<?> getDoctorTreatmentList(@PathVariable Long id) throws URISyntaxException {
        List<DoctorTreatmentHistoryDTO> allTreatmentRecordsForDoctor = doctorService.getAllTreatmentRecordsForDoctor(id);
        String url = "/doctor/" + id + "/mypage";
        if(!allTreatmentRecordsForDoctor.isEmpty()){
            return ResponseEntity.created(new URI(url)).body(allTreatmentRecordsForDoctor.iterator());
        }else{
            return ResponseEntity.created(new URI(url)).body("아직 진료를 보신적이 없으세요");
        }
    }
    /**
     * 수의사의 오늘 진료들 확인
     */
    @GetMapping("/{id}/today-treatment")
    public ResponseEntity<?> getDoctorSchedule(@PathVariable Long id) throws URISyntaxException {
        List<DoctorTodayTreatmentScheduleDTO> doctorTodaySchedule = doctorService.getDoctorTodaySchedule(id);
        String url = "/doctor/" + id + "/mypage";

        if(!doctorTodaySchedule.isEmpty()){
            return ResponseEntity.created(new URI(url)).body(doctorTodaySchedule);
        }else{
            return ResponseEntity.created(new URI(url)).body("오늘은 예약된 진료가 없습니다.");
        }
    }

}

