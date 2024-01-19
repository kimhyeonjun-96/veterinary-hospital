package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.Member;

import java.util.Optional;

public interface MemberService {
    public Member join(Member member);

    public void validateDuplicateMember(Member member);

    public Optional<Member> findOne(Long memberId);

}
