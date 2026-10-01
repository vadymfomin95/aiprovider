package ua.nure.fomin.aiprovider.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ChatMessage(
        @Schema(description = "Prompt text to send to the AI model", example = "What is the capital of France?")
        String message) {
}
