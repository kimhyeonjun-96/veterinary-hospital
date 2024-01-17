package com.myProject.treatment.domain.user.service;

import com.myProject.treatment.domain.user.domain.Member;

import java.util.Optional;

public interface MemberService {
    public Long join(Member member);

    public void validateDuplicateMember(Member member);

    public Optional<Member> findOne(Long memberId);

}
