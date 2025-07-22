package com.mentorship.platform.controller;

import com.mentorship.platform.ai.AISummarizationService;
import com.mentorship.platform.model.RecordingWebhookPayload;
import com.mentorship.platform.model.TranscriptionCompletePayload;
import com.mentorship.platform.service.TranscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks")
@RequiredArgsConstructor
public class WebhookController {

    private final TranscriptionService transcriptionService;
    private final AISummarizationService summarizationService;

    @PostMapping("/recording-ready")
    public ResponseEntity<?> handleRecordingReady(@RequestBody RecordingWebhookPayload payload) {
        transcriptionService.submitForTranscription(payload.getAudioUrl(), payload.getBookingId());
        return ResponseEntity.ok("Recording received.");
    }

    @PostMapping("/transcription-complete")
    public ResponseEntity<?> handleTranscriptionComplete(@RequestBody TranscriptionCompletePayload payload) {
        String summary = summarizationService.generateSummary(payload.getTranscript());
        return ResponseEntity.ok(summary);
    }
}
