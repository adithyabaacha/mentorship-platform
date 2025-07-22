package com.mentorship.platform.ai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class AISummarizationService {

    private final WebClient webClient = WebClient.create("https://api.openai.com");

    public String generateSummary(String transcript) {
        String prompt = "You are an expert assistant who summarizes mentorship calls for students. " +
                "Analyze the following transcript. Your output must be in Markdown format and include:\n" +
                "1. A short summary of the key topics discussed.\n" +
                "2. A 'Key Takeaways' section with a bulleted list of actionable advice.\n" +
                "3. A 'Resources Mentioned' section listing any books, websites, or tools discussed.\n\n" +
                transcript;

        String apiKey = System.getenv("OPENAI_API_KEY");

        return webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue("""
                {
                  "model": "gpt-4",
                  "messages": [
                    { "role": "system", "content": "You are a helpful summarization assistant." },
                    { "role": "user", "content": "%s" }
                  ]
                }
                """.formatted(prompt))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
