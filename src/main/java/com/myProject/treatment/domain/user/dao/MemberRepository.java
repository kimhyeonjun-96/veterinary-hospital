package com.myProject.treatment.domain.user.dao;

import com.myProject.treatment.domain.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByMemberIdAndMemberName(String memberId, String memberName);
}
