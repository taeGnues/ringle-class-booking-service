package com.ringle.ringleclassbookingservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private ErrorCode status;

    public BaseException(ErrorCode status) {
        super(status.getMessage());
        this.status = status;
    }
}
