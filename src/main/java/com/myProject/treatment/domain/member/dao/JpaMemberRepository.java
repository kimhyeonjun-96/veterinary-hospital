package com.myProject.treatment.domain.member.dao;

import com.myProject.treatment.domain.member.Member;
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
    public Member saveMember(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByMemberIdAndMemberName(String member_id, String member_name) {
        List<Member> result = em.createQuery("select m from Member m where m.memberId = :member_id and m.memberName = : member_name", Member.class)
                .setParameter("member_id", member_id)
                .setParameter("member_name", member_name)
                .getResultList();

        return result.stream().findAny();
    }
}
