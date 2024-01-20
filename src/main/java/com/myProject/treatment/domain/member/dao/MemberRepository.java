package com.myProject.treatment.domain.member.dao;

import com.myProject.treatment.domain.member.MemberDTO;

import java.util.Optional;

public interface MemberRepository {
    MemberDTO saveMember(MemberDTO memberDTO);

    Optional<MemberDTO> findById(Long id);

    Optional<MemberDTO> findByMemberIdAndMemberName(String memberId, String memberName);
}
