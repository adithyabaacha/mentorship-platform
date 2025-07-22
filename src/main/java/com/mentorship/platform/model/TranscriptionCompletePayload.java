package com.mentorship.platform.model;

import lombok.Data;

@Data
public class TranscriptionCompletePayload {
    private String transcript;
    private String bookingId;
}
