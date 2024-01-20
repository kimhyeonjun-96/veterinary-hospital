package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;
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
        memberRepository.saveMember(new Member(memberDTO.getMemberId(), memberDTO.getMemberPwd(), memberDTO.getMemberName(), memberDTO.getMemberPhone(), memberDTO.getAddress()));
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
    public MemberDTO findOneMember(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return new MemberDTO(memberId, member.getMemberId(), member.getMemberPwd(), member.getMemberName(), member.getMemberPhone(), member.getAddress());
    }
}
