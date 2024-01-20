package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.MemberDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
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
    public MemberDTO signupMember(MemberDTO memberDTO) {
        validateDuplicateMember(memberDTO);
        memberRepository.saveMember(memberDTO);

        return memberDTO;
    }

    /**
     *회원가입 시 중복회원 검증
     */
    @Override
    public void validateDuplicateMember(MemberDTO memberDTO) {
        memberRepository.findByMemberIdAndMemberName(memberDTO.getMemberId(), memberDTO.getMemberName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 회원 조회
     */
    @Override
    public Optional<MemberDTO> findOneMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
