package com.myProject.treatment.domain.member.dao;

import com.myProject.treatment.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByMemberIdAndMemberName(String memberId, String memberName);
}
