package com.ringle.ringleclassbookingservice.persist.repository;

import com.ringle.ringleclassbookingservice.persist.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Optional<Tutor> findByEmail(String email);
}
