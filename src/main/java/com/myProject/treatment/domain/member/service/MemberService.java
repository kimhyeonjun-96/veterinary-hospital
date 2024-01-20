package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.MemberDTO;

import java.util.Optional;

public interface MemberService {
    public MemberDTO signupMember(MemberDTO memberDTO);

    public void validateDuplicateMember(MemberDTO memberDTO);

    public Optional<MemberDTO> findOneMember(Long memberId);

}
