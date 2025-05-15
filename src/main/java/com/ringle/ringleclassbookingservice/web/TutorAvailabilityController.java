package com.ringle.ringleclassbookingservice.web;

import com.ringle.ringleclassbookingservice.dto.request.CreateAvailabilityReqDto;
import com.ringle.ringleclassbookingservice.dto.response.BaseResponse;
import com.ringle.ringleclassbookingservice.exception.ErrorCode;
import com.ringle.ringleclassbookingservice.service.TutorAvailabilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutor/availability")
public class TutorAvailabilityController {

    private final TutorAvailabilityService tutorAvailabilityService;

    // 1. 수업 가능한 시간대 생성
    @PostMapping
    public BaseResponse<Void> createAvailability(
            @RequestBody @Valid CreateAvailabilityReqDto request
    ) {
        tutorAvailabilityService.createAvailability(request.email(), request.startTime());
        return new BaseResponse<>(ErrorCode.CREATED);
    }

    // 2. 수업 가능한 시간대 삭제

}
