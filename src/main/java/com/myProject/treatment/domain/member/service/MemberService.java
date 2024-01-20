package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {
    public MemberDTO signupMember(MemberDTO memberDTO);

    public void validateDuplicateMember(MemberDTO memberDTO);

    public MemberDTO findOneMember(Long memberId);

}
