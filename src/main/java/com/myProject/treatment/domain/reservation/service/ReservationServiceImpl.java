package com.myProject.treatment.domain.reservation.service;

import com.myProject.treatment.domain.animal.Animal;
import com.myProject.treatment.domain.animal.dao.AnimalRepository;
import com.myProject.treatment.domain.doctor.Doctor;
import com.myProject.treatment.domain.doctor.dao.DoctorRepository;
import com.myProject.treatment.domain.reservation.Reservation;
import com.myProject.treatment.domain.reservation.dao.ReservationRepository;
import com.myProject.treatment.domain.reservation.dto.ReservationDTO;
import com.myProject.treatment.domain.treatment.Treatment;
import com.myProject.treatment.domain.treatment.dto.TreatmentDTO;
import com.myProject.treatment.domain.treatment.service.TreatmentServiceImpl;
import com.myProject.treatment.errors.errorcode.MemberErrorCode;
import com.myProject.treatment.errors.exception.AlreadyReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationServiceImpl{

    private final ReservationRepository reservationRepository;
    private final AnimalRepository animalRepository;
    private final DoctorRepository doctorRepository;
    private final TreatmentServiceImpl treatmentService;

    @Transactional
    public ReservationDTO createReservation(Long memberId, TreatmentDTO treatmentDTO, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        // 선택된 의사 가져오기
        Doctor doctor = doctorRepository.findById(treatmentDTO.getDoctorId()).get();

        // 선택한 시간 가능한지 확인
        checkReservationTime(doctor.getId(), selectStartTime, selectEndTime);

        // 엔티티 조회 - { 진료 정보 저장, 예약 정보 저장을 위한 반려동물 데이터, 예약 정보 저장}
        Treatment saveTreatment = treatmentService.createTreatment(memberId, treatmentDTO); //
        Animal animal = animalRepository.findById(saveTreatment.getAnimalId()).get(); //
        Reservation reservation = reservationRepository.saveTheReservation(new Reservation(selectStartTime, selectEndTime, animal.getId(), doctor.getId(), saveTreatment.getId()));
        // 반환 - { ReservationDTO를 반환 }
        return new ReservationDTO(reservation.getId(), reservation.getReservationStartTime(), reservation.getReservationEndTime(), reservation.getAnimalId(), reservation.getDoctorId(), reservation.getTreatmentId());
    }

    public void checkReservationTime(Long doctorId, LocalDateTime selectStartTime, LocalDateTime selectEndTime) {
        // 수의사의 진료예약이 된 시간을 가져오기
        List<ReservationDTO> reservationTimeDTOList = reservationRepository.findByDoctorIdReservationTime(doctorId);
        selectStartTime = typeConversion(selectStartTime);
        for(ReservationDTO reservationDTO : reservationTimeDTOList){
            LocalDateTime existingTime = typeConversion(reservationDTO.getReservationStartTime());
            if(existingTime.equals(selectStartTime)){
                throw new AlreadyReservationException(MemberErrorCode.DUPLICATED_RESERVATION_TIME);
            }
        }
    }

    private LocalDateTime typeConversion(LocalDateTime time){
        DateTimeFormatter coversionTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strTime = time.format(coversionTime);
        return LocalDateTime.parse(strTime, coversionTime);
    }

}
