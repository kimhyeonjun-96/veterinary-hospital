package com.myProject.treatment.errors.handler;

import com.myProject.treatment.errors.errorcode.ErrorCode;
import com.myProject.treatment.errors.exception.AlreadyReservationException;
import com.myProject.treatment.errors.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MemberExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(AlreadyReservationException.class)
//    public ResponseEntity<Object> handleAlreadyReservationException(AlreadyReservationException e){
//        ErrorCode errorCode = e.getErrorCode();
//        return handleExceptionInternal(errorCode);
//    }
//
//    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(errorCode));
//    }
//
//    private ErrorResponse makeErrorResponse(ErrorCode errorCode) {
//        return ErrorResponse.builder()
//                .code(errorCode.name())
//                .message(errorCode.getMessage())
//                .build();
//    }

}
