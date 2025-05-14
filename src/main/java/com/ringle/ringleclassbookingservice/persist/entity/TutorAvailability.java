package com.ringle.ringleclassbookingservice.persist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "TUTOR_AVAILABILITY",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"tutor_id", "start_time"})
        }
)
public class TutorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_availability_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "is_booked", nullable = false)
    private boolean isBooked = false;
}
