package com.myProject.treatment.domain.member.controller;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AnimalServiceImpl animalService;

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
    @PostMapping("/mypage")
    public ResponseEntity<?> myPageMember(@RequestBody Map<String, Long> request){
        Long id = request.get("id");
        MemberDTO memberDTO = memberService.findOneMember(id);

        if (memberDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(memberDTO);
    }

    /**
     * 회원 반려동물 등록
     */
    @PostMapping("/registMyPet")
    public ResponseEntity<?> registPetMember(@RequestBody AnimalDTO resource, @RequestParam Long id)throws URISyntaxException{
        MemberDTO memberDTO = memberService.findOneMember(id);
        Animal animal = animalService.regist(new Animal(resource.getName(), resource.getHeight(), resource.getWeight(), resource.getTYPE(), memberDTO), memberDTO.getId());

        String url = "/members/" + animal.getMemberID() + "/" + animal.getName();
        String responseBody = "memberId: " + animal.getMemberID().getID() + ", petName: " + animal.getName();

        return ResponseEntity.created(new URI(url)).body(responseBody);
    }
}
