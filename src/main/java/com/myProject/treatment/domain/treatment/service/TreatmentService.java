package com.myProject.treatment.domain.treatment.service;

import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TreatmentService {
    // 진료 생성 및 예약 생성
    Treatment createTreatment(Long memberId, TreatmentDTO treatmentDTO);

    // 회원의 진료 기록들 확인

    // 회원의 예약 확인

    // 수의사의 오늘 진료 리스트

}
