package com.myProject.treatment.domain.member.dao;

import com.myProject.treatment.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {
    Member saveMember(Member memberDTO);

    Optional<Member> findById(Long id);

    Optional<Member> findByMemberIdAndMemberName(String memberId, String memberName);
}
