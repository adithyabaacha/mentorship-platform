package com.mentorship.platform.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long menteeId;
    private Long mentorId;

    @Enumerated(EnumType.STRING)
    private BookingType type; // FREE, PAID

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, CONFIRMED

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
