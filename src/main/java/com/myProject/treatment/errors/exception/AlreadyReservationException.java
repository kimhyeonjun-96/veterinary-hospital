package com.myProject.treatment.errors.exception;

import com.myProject.treatment.errors.errorcode.CustomErrorCode;
import com.myProject.treatment.errors.errorcode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AlreadyReservationException extends RuntimeException{

    private final ErrorCode errorCode;

}
