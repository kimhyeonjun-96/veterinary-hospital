package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.dto.MemberDTO;

public interface MemberService {
    // 회원 회원가입
    public MemberDTO signupMember(MemberDTO aMemberDTO);

    // 회원가입 시 아이디 중복 확인
    public void validateDuplicateMember(MemberDTO aMemberDTO);

    // 특정 회원 정보 조회
    public MemberDTO findOneMember(java.lang.Long memberId);

    // 회원 존재여부 확인
    public boolean authenticateMember(java.lang.Long memberId);

}
