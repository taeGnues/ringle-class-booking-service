package com.ringle.ringleclassbookingservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateAvailabilityReqDto(
        @NotBlank(message = "이메일이 공란이면 안됩니다.")
        @Email
        String email,
        @NotNull(message = "시작시간이 공란이면 안됩니다.")
        LocalDateTime startTime
) {
}
