package com.myProject.treatment.domain.treatment.dao;

import com.myProject.treatment.domain.doctor.dto.DoctorTreatmentHistoryDTO;
import com.myProject.treatment.domain.doctor.dto.DoctorTodayTreatmentScheduleDTO;
import com.myProject.treatment.domain.member.dto.MemberTreatmentHistoryDTO;
import com.myProject.treatment.domain.treatment.Treatment;

import java.util.List;

public interface TreatmentRepository {
    // 새로운 진료 저장
    Treatment saveTreatment(Treatment treatment);

    // 회원의 진료들 찾기
    List<MemberTreatmentHistoryDTO> findTreatmentListByMemberId(Long memberId);

    // 수의사의 진료들 찾기
    List<DoctorTreatmentHistoryDTO> findTreatmentListByDoctorId(Long doctorId);

    // 수의사 오늘의 진료 찾기
    List<DoctorTodayTreatmentScheduleDTO> findTodayTreatmentListByDoctorId(Long doctorId);
}
