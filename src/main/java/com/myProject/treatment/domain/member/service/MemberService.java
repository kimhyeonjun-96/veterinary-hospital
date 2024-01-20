package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {
    // 회원 회원가입
    public MemberDTO signupMember(MemberDTO memberDTO);

    // 회원가입 시 아이디 중복 확인
    public void validateDuplicateMember(MemberDTO memberDTO);

    // 특정 회원 정보 조회
    public MemberDTO findOneMember(Long memberId);

    // 회원 진료 예약

}
