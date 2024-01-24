package com.myProject.treatment.domain.member.service;

import com.myProject.treatment.domain.member.dao.MemberRepository;
import com.myProject.treatment.domain.member.Member;
import com.myProject.treatment.domain.member.dto.MemberDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl{

    private final MemberRepository memberRepository;

    /**
     *회원가입
     */
    public MemberDTO signupMember(MemberDTO aMemberDTO) {
        validateDuplicateMember(aMemberDTO);
        memberRepository.saveMember(new Member(aMemberDTO.getMemberId(), aMemberDTO.getMemberPwd(), aMemberDTO.getMemberName(), aMemberDTO.getMemberPhone(), aMemberDTO.getAddress()));
        return aMemberDTO;
    }

    /**
     *회원가입 시 중복회원 검증
     */
    public void validateDuplicateMember(MemberDTO aMemberDTO) {
        memberRepository.findByMemberIdAndMemberName(aMemberDTO.getMemberId(), aMemberDTO.getMemberName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 회원 조회
     */
    public MemberDTO findOneMember(java.lang.Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return new MemberDTO(memberId, member.getMemberId(), member.getMemberPwd(), member.getMemberName(), member.getMemberPhone(), member.getAddress());
    }

    /**
     * 진료 예약을 위한 회원 존재여부 확인
     */
    public boolean authenticateMember(java.lang.Long memberId) {
        Member member = memberRepository.findById(memberId).get();

        if(member == null){
            return false;
        }else{
            return true;
        }
    }
}
