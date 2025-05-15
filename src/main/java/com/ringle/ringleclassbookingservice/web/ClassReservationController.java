package com.ringle.ringleclassbookingservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/class")
public class ClassReservationController {

    // 기간 & 수업 길이로 현재 수업 가능한 시간대 조회

    // 시간대 & 수업 길이로 수업 가능한 튜터 조회 (각 튜터당 3개의 시간대)

    // 시간대 / 수업 길이 / 튜터로 새로운 수업 신청

    // 신청한 수업 조회

}
