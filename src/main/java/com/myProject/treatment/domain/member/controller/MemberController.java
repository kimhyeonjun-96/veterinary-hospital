package com.myProject.treatment.domain.member.controller;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorServiceImpl;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberServiceImpl;
import com.myProject.treatment.domain.reservation.dto.CreateReservationRequest;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.reservation.service.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberServiceImpl memberService;
    private final AnimalServiceImpl animalService;
    private final DoctorServiceImpl doctorService;
    private final ReservationServiceImpl reservationService;

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signupMember(@RequestBody MemberDTO aMemberDTO)throws URISyntaxException{
        MemberDTO addMemberDTO = memberService.signupMember(aMemberDTO);
        String url = "/members/" + addMemberDTO.getId();
        return ResponseEntity.created(new URI(url)).body(addMemberDTO.getMemberName());
    }


    /**
     * 회원 마이페이지
     */
    @PostMapping("/{id}/mypage")
    public ResponseEntity<?> myPageMember(@PathVariable java.lang.Long id){
        MemberDTO aMemberDTO = memberService.findOneMember(id);
        if (aMemberDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(aMemberDTO);
    }

    /**
     * 회원 반려동물 등록
     */
    @PostMapping("/{id}/registMyPet")
    public ResponseEntity<?> registPetMember(@RequestBody AnimalDTO resource, @PathVariable java.lang.Long id)throws URISyntaxException{
        MemberDTO aMemberDTO = memberService.findOneMember(id);
        AnimalDTO animalDTO = animalService.registAnimal(resource, id);

        String url = "/members/" + animalDTO.getMemberId() + "/" + animalDTO.getName();
        String responseBody = "memberId: " + animalDTO.getMemberId() + ", petName: " + animalDTO.getName();

        return ResponseEntity.created(new URI(url)).body(responseBody);
    }

    /**
     * 회원 진료예약을 위한 데이터 전달
     * 진료를 위한 데이터 선택을 하기 위함
     * feature/treatment-reservation 브랜치 추가
     */
    @GetMapping("/{id}/gatherReservation")
    public ResponseEntity<?> gatherReservationMember(@PathVariable java.lang.Long id)throws URISyntaxException{
        if(!memberService.authenticateMember(id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: Invalid credentials");

        List<AnimalDTO> animalList = animalService.getAnimalList(id);
        List<DoctorDTO> allDoctor = doctorService.findAllDoctor();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("animalList", animalList);
        responseData.put("allDoctor", allDoctor);

        return ResponseEntity.ok(responseData);
    }

    /**
     * get메서드를 통한 데이터 확인 후, 전달받은 진료데이터를 기잔으로 예약 진행
     * feature/treatment-reservation 브랜치 추가
     */
    @PostMapping("/{id}/createReservation")
    public ResponseEntity<?> createReservationMember(
            @PathVariable Long id,
            @RequestBody CreateReservationRequest request)throws URISyntaxException{
        ReservationDTO reservation = reservationService.createReservation(id, request.getTreatmentDTO(), request.getSelectStartTime(), request.getSelectEndTime());

        String url = "/members/" + id;
        if(reservation != null)
            return ResponseEntity.created(new URI(url)).body(reservation);
        else
            return ResponseEntity.created(new URI(url)).body("예약하지 못 했습니다.");
    }

}
