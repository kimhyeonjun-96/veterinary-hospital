package com.myProject.treatment.domain.member.controller;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorService;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberService;
import com.myProject.treatment.domain.reservation.dto.CreateReservationRequest;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.reservation.service.ReservationService;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AnimalServiceImpl animalService;
    private final DoctorService doctorService;
    private final ReservationService reservationService;

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signupMember(@RequestBody MemberDTO memberDTO)throws URISyntaxException{
        MemberDTO addMemberDTO = memberService.signupMember(memberDTO);
        String url = "/members/" + addMemberDTO.getId();
        return ResponseEntity.created(new URI(url)).body(addMemberDTO.getMemberName());
    }


    /**
     * 회원 마이페이지
     */
    @PostMapping("/{id}/mypage")
    public ResponseEntity<?> myPageMember(@PathVariable Long id){
        MemberDTO memberDTO = memberService.findOneMember(id);
        if (memberDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(memberDTO);
    }

    /**
     * 회원 반려동물 등록
     */
    @PostMapping("/{id}/registMyPet")
    public ResponseEntity<?> registPetMember(@RequestBody AnimalDTO resource, @PathVariable Long id)throws URISyntaxException{
        MemberDTO memberDTO = memberService.findOneMember(id);
        AnimalDTO animalDTO = animalService.registAnimal(resource, id);

        String url = "/members/" + animalDTO.getMemberId() + "/" + animalDTO.getName();
        String responseBody = "memberId: " + animalDTO.getMemberId() + ", petName: " + animalDTO.getName();

        return ResponseEntity.created(new URI(url)).body(responseBody);
    }

    /**
     * 회원 진료예약을 위한 데이터 전달
     * 진료를 위한 데이터 선택을 하기 위함
     */
    @GetMapping("/{id}/gatherReservation")
    public ResponseEntity<?> gatherReservationMember(@PathVariable Long id)throws URISyntaxException{
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
     */
    @PostMapping("/{id}/createReservation")
    public ResponseEntity<?> createReservationMember(
            @PathVariable Long id,
            @RequestBody CreateReservationRequest request)throws URISyntaxException{
        ReservationDTO reservation = reservationService.createReservation(id, request.getTreatmentDTO(), request.getSelectStartTime(), request.getSelectEndTime());

        String url = "/members/" + id;

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
