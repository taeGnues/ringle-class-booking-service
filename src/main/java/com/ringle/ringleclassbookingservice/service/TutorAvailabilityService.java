package com.ringle.ringleclassbookingservice.service;

import java.time.LocalDateTime;

public interface TutorAvailabilityService {
    void createAvailability(String email, LocalDateTime startTime);
}
