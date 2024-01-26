package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.member.dto.MemberTreatmentHistoryDTO;
import com.myProject.treatment.domain.treatment.Treatment;

import java.util.List;

public interface TreatmentRepository {
    // 새로운 진료 저장
    Treatment saveTreatment(Treatment treatment);

    // 회원의 진료들 찾기
    List<MemberTreatmentHistoryDTO> findTreatmentListByMemberId(Long memberId);

}
