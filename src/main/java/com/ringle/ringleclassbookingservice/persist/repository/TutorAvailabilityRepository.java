package com.ringle.ringleclassbookingservice.persist.repository;

import com.ringle.ringleclassbookingservice.persist.entity.Tutor;
import com.ringle.ringleclassbookingservice.persist.entity.TutorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long> {
    boolean existsByTutorAndStartTime(Tutor tutor, LocalDateTime startTime);
}
