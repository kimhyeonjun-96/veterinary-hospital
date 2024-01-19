package com.myProject.treatment.domain.user.service;

import com.myProject.treatment.domain.user.dao.MemberRepository;
import com.myProject.treatment.domain.user.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *회원가입
     */
    @Override
    public Member join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member;
    }

    /**
     *회원가입 시 중복회원 검증
     */
    @Override
    public void validateDuplicateMember(Member member) {
        memberRepository.findByMemberIdAndMemberName(member.getMember_id(), member.getMember_name()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
