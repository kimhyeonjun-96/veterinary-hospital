package com.myProject.treatment.domain.user.dao;

import com.myProject.treatment.domain.user.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByMemberIdAndMemberName(String MemberId, String MemberName) {
        List<Member> result = em.createQuery("select m from Member m where m.MemberId = :MemberId and m.MemberName = : MemberName", Member.class)
                .setParameter("MemberId", MemberId)
                .setParameter("MemberName", MemberName)
                .getResultList();

        return result.stream().findAny();
    }
}
