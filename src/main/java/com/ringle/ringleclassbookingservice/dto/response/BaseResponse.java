package com.ringle.ringleclassbookingservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ringle.ringleclassbookingservice.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String message;
    private final int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청에 성공한 경우
    public BaseResponse(T result) {
        this.isSuccess = ErrorCode.SUCCESS.isSuccess();
        this.message = ErrorCode.SUCCESS.getMessage();
        this.code = ErrorCode.SUCCESS.getCode();
        this.result = result;
    }

    // 요청에 실패한 경우
    public BaseResponse(ErrorCode status) {
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
        this.code = status.getCode();
    }

    public BaseResponse(ErrorCode status, String validMessage) {
        this.isSuccess = status.isSuccess();
        this.message = validMessage != null && !validMessage.isEmpty() ? validMessage : status.getMessage();
        this.code = status.getCode();
    }
}

