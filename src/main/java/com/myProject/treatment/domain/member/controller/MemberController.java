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
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody MemberDTO resource)throws URISyntaxException{
        String memberId = resource.getMemberId();
        String memberPwd = resource.getMemberPwd();
        String memberName = resource.getMemberName();
        String memberPhone = resource.getMemberPhone();
        String address = resource.getAddress();

        Member addMember = memberService.join(new Member(memberId, memberPwd, memberName, memberPhone, address));

        String url = "/members/" + addMember.getId();

        return ResponseEntity.created(new URI(url)).body(addMember.getMember_name());
    }

//    @GetMapping("/mypage")
//    public ResponseEntity<?> mypage(@RequestParam Long id) throws URISyntaxException{
//        Member member = memberService.findOne(id).orElse(null);
//
//        if (member == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        String url = "/members/mypage" + member.getID();
//
//        return ResponseEntity.ok(member);
//    }

    /**
     * 회원 마이페이지
     */
    @PostMapping("/mypage")
    public ResponseEntity<?> mypage(@RequestBody Map<String, Long> request) throws URISyntaxException{
        Long id = request.get("id");
        Member member = memberService.findOne(id).orElse(null);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        String url = "/members/mypage" + member.getId();

        return ResponseEntity.ok(member);
    }

    /**
     * 회원 반려동물 등록
     */
    @PostMapping("/registMyPet")
    public ResponseEntity<?>registMyPet(@RequestBody AnimalDTO resource, @RequestParam Long id)throws URISyntaxException{
        Member member = memberService.findOne(id).get();
        Animal animal = animalService.regist(new Animal(resource.getName(), resource.getHeight(), resource.getWeight(), resource.getTYPE(), member), member.getId());

        String url = "/members/" + animal.getMemberID() + "/" + animal.getName();
        String responseBody = "memberId: " + animal.getMemberID().getID() + ", petName: " + animal.getName();

        return ResponseEntity.created(new URI(url)).body(responseBody);
    }
}
