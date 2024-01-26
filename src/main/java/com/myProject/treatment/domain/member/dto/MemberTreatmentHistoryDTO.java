package com.myProject.treatment.domain.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemberTreatmentHistoryDTO {
    private Long treatmentId;
    private String purpose;
    private String memberName;
    private String memberPhone;
    private String animalName;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private String doctorName;

    public MemberTreatmentHistoryDTO(Long treatmentId, String purpose, String memberName, String memberPhone, String animalName, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, String doctorName) {
        this.treatmentId = treatmentId;
        this.purpose = purpose;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.animalName = animalName;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "MemberTreatmentHistoryDTO{" +
                "treatmentId=" + treatmentId +
                ", purpose='" + purpose + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", animalName='" + animalName + '\'' +
                ", reservationStartTime=" + reservationStartTime +
                ", reservationEndTime=" + reservationEndTime +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
