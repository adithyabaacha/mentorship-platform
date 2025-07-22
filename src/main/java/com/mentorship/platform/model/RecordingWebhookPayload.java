package com.mentorship.platform.model;

import lombok.Data;

@Data
public class RecordingWebhookPayload {
    private String audioUrl;
    private String bookingId;
}
