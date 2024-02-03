package com.myProject.treatment.errors.errorcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode{

    DUPLICATED_RESERVATION_TIME(HttpStatus.CONFLICT, "이미 예약된 시간입니다."),;

    private final HttpStatus httpStatus;
    private final String message;
}
