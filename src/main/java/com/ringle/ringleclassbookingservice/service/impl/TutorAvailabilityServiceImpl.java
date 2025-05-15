package com.ringle.ringleclassbookingservice.service.impl;

import com.ringle.ringleclassbookingservice.exception.BaseException;
import com.ringle.ringleclassbookingservice.exception.ErrorCode;
import com.ringle.ringleclassbookingservice.persist.entity.Tutor;
import com.ringle.ringleclassbookingservice.persist.entity.TutorAvailability;
import com.ringle.ringleclassbookingservice.persist.repository.TutorAvailabilityRepository;
import com.ringle.ringleclassbookingservice.persist.repository.TutorRepository;
import com.ringle.ringleclassbookingservice.service.TutorAvailabilityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TutorAvailabilityServiceImpl implements TutorAvailabilityService {

    private final TutorAvailabilityRepository tutorAvailabilityRepository;
    private final TutorRepository tutorRepository;

    @Override
    @Transactional
    public void createAvailability(String email, LocalDateTime startTime) {

        // 생성하고자 하는 시간이 30분 혹은 00분 단위 인지 검사
        if (startTime.getMinute() != 0 && startTime.getMinute() != 30) {
            throw new BaseException(ErrorCode.WRONG_CLASS_START_TIME);
        }

        Tutor tutor = tutorRepository.findByEmail(email)
                .orElseThrow(() -> new BaseException(ErrorCode.NOT_FOUND_TUTOR));

        // 등록하려는 시간정보가 이미 존재하는지 확인
        if (tutorAvailabilityRepository.existsByTutorAndStartTime(tutor, startTime)) {
            throw new BaseException(ErrorCode.DUPLICATED_CLASS_START_TIME);
        }

        TutorAvailability availability = TutorAvailability.builder()
                .tutor(tutor)
                .startTime(startTime)
                .isBooked(false)
                .build();

        tutorAvailabilityRepository.save(availability);
    }
}
