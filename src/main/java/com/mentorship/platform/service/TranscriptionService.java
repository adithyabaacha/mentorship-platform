package com.mentorship.platform.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class TranscriptionService {

    private final WebClient webClient = WebClient.create("https://api.assemblyai.com/v2");

    public void submitForTranscription(String audioUrl, String bookingId) {
        String apiKey = System.getenv("ASSEMBLYAI_API_KEY");

        webClient.post()
                .uri("/transcript")
                .header("Authorization", apiKey)
                .bodyValue("""
                    {
                      "audio_url": "%s",
                      "webhook_url": "https://yourdomain.com/api/webhooks/transcription-complete?bookingId=%s"
                    }
                    """.formatted(audioUrl, bookingId))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
