package com.myProject.treatment.domain.member.controller;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dto.AnimalDTO;
import com.myProject.treatment.domain.animal.service.AnimalServiceImpl;
import com.myProject.treatment.domain.member.MemberDTO;
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
    public ResponseEntity<?> signUpMember(@RequestBody MemberDTO resource)throws URISyntaxException{

        MemberDTO addMemberDTO = memberService.signupMember(resource);

        String url = "/members/" + addMemberDTO.getId();

        return ResponseEntity.created(new URI(url)).body(addMemberDTO.getMemberName());
    }


    /**
     * 회원 마이페이지
     */
    @PostMapping("/mypage")
    public ResponseEntity<?> myPageMember(@RequestBody Map<String, Long> request) throws URISyntaxException{
        Long id = request.get("id");
        MemberDTO memberDTO = memberService.findOneMember(id).orElse(null);

        if (memberDTO == null) {
            return ResponseEntity.notFound().build();
        }
        String url = "/members/mypage" + memberDTO.getId();

        return ResponseEntity.ok(memberDTO);
    }

    /**
     * 회원 반려동물 등록
     */
    @PostMapping("/registMyPet")
    public ResponseEntity<?> registPetMember(@RequestBody AnimalDTO resource, @RequestParam Long id)throws URISyntaxException{
        MemberDTO memberDTO = memberService.findOneMember(id).get();
        Animal animal = animalService.regist(new Animal(resource.getName(), resource.getHeight(), resource.getWeight(), resource.getTYPE(), memberDTO), memberDTO.getId());

        String url = "/members/" + animal.getMemberID() + "/" + animal.getName();
        String responseBody = "memberId: " + animal.getMemberID().getID() + ", petName: " + animal.getName();

        return ResponseEntity.created(new URI(url)).body(responseBody);
    }
}
