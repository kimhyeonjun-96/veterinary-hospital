package com.myProject.treatment.domain.member.controller;

import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.doctor.dto.DoctorDTO;
import com.myProject.treatment.domain.doctor.service.DoctorServiceImpl;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.dto.MemberTreatmentHistoryDTO;
import com.myProject.treatment.domain.member.service.MemberServiceImpl;
import com.myProject.treatment.domain.reservation.dto.CreateReservationRequest;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.reservation.service.ReservationServiceImpl;;
import com.myProject.treatment.errors.errorcode.MemberErrorCode;
import com.myProject.treatment.errors.exception.AlreadyReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

        if(Objects.isNull(reservation)){
            throw new AlreadyReservationException(MemberErrorCode.DUPLICATED_RESERVATION_TIME);
        }
        String url = "/members/" + id;
        return ResponseEntity.ok(new MemberCommonResponse("sucess", "선택한 시간으로 예약 되었습니다.", reservation));
    }

    /**
     * 회원 정보 수정
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMemberInfo(@PathVariable Long id, @RequestBody MemberDTO memberDTO) throws URISyntaxException {
        MemberDTO updateMember = memberService.updateMember(id, memberDTO);
        String url = "/members/" + id;
        if(updateMember != null){
            return ResponseEntity.created(new URI(url)).body(updateMember);
        }else{
            return ResponseEntity.created(new URI(url)).body("회원의 정보를 업데이트 하지 못 했습니다.");
        }
    }

    /**
     * 회원 진료내역 전체 리스트 확인
     */
    @GetMapping("{id}/mypage/getTreatmentList")
    public ResponseEntity<?> getTreatmentList(@PathVariable Long id)throws URISyntaxException{
        List<MemberTreatmentHistoryDTO> allTreatmentRecordsForMember = memberService.getAllTreatmentRecordsForMember(id);
        String url = "/members/" + id + "/mypage";

        if(!allTreatmentRecordsForMember.isEmpty()){
            return ResponseEntity.created(new URI(url)).body(allTreatmentRecordsForMember.iterator());
        }else{
            return ResponseEntity.created(new URI(url)).body("아직 진료를 보신적이 없으세요");
        }
    }

}
