package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;

import java.util.Optional;

public interface MemberService {
    // 회원 회원가입
    public MemberDTO signupMember(MemberDTO memberDTO);

    // 회원가입 시 아이디 중복 확인
    public void validateDuplicateMember(MemberDTO memberDTO);

    // 특정 회원 정보 조회
    public MemberDTO findOneMember(Long memberId);

    // 회원 존재여부 확인
    public boolean authenticateMember(Long memberId);

}
