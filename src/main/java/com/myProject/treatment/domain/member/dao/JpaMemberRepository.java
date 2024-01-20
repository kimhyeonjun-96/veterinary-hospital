package com.myProject.treatment.domain.member.dao;

import com.myProject.treatment.domain.member.MemberDTO;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public MemberDTO saveMember(MemberDTO memberDTO) {
        em.persist(memberDTO);
        return memberDTO;
    }

    @Override
    public Optional<MemberDTO> findById(Long id) {
        MemberDTO memberDTO = em.find(MemberDTO.class, id);
        return Optional.ofNullable(memberDTO);
    }

    @Override
    public Optional<MemberDTO> findByMemberIdAndMemberName(String member_id, String member_name) {
        List<MemberDTO> result = em.createQuery("select m from MemberDTO m where m.memberId = :member_id and m.memberName = : member_name", MemberDTO.class)
                .setParameter("member_id", member_id)
                .setParameter("member_name", member_name)
                .getResultList();

        return result.stream().findAny();
    }
}
