package com.ringle.ringleclassbookingservice.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 에러 코드 관리
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    /**
     * 200 : 요청 성공
     */
    SUCCESS(true, HttpStatus.OK.value(), "요청 성공"),
    NO_CONTENT(true, HttpStatus.NO_CONTENT.value(), "요청 성공 (no content)"),
    CREATED(true, HttpStatus.CREATED.value(), "요청 성공 (created)"),

    /**
     * 400 : Request, Response 오류
     */
    NOT_FOUND_TUTOR(false, HttpStatus.NOT_FOUND.value(), "일치하는 튜터가 없습니다."),

    VALIDATION_ERROR(false, HttpStatus.BAD_REQUEST.value(), "요청 데이터 검증 오류"),
    DUPLICATED_CLASS_START_TIME(false, HttpStatus.BAD_REQUEST.value(), "이미 해당 시간은 열려 있습니다."),
    WRONG_CLASS_START_TIME(false, HttpStatus.BAD_REQUEST.value(), "수업 시작 시간은 정각 또는 30분이어야 합니다."),

    /**
     * 500 : Database, Server 오류
     */
    UNEXPECTED_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "예상치 못한 에러가 발생했습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;
}
