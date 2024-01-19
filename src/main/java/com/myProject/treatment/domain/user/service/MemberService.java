package com.myProject.treatment.domain.user.service;

import com.myProject.treatment.domain.user.domain.Member;
import com.myProject.treatment.domain.user.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {
    public Member join(Member member);

    public void validateDuplicateMember(Member member);

    public Optional<Member> findOne(Long memberId);

}
