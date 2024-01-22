package com.myProject.treatment.domain.reservation.dto;

import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CreateReservationRequest {
    private TreatmentDTO treatmentDTO;
    private LocalDateTime selectStartTime;
    private LocalDateTime selectEndTime;
}
