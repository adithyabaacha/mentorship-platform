package com.mentorship.platform.dto;

import com.mentorship.platform.model.BookingStatus;
import com.mentorship.platform.model.BookingType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {
    private Long id;
    private BookingType type;
    private BookingStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
