package com.mentorship.platform.dto;

import com.mentorship.platform.model.BookingType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private Long menteeId;
    private Long mentorId;
    private BookingType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
