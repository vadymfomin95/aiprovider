package ua.nure.fomin.aiprovider.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.fomin.aiprovider.dto.ChatMessage;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Chat", description = "Send prompts to the AI model")
public class ChatController {

    private final ChatClient chatClient;

    @PostMapping
    @Operation(summary = "Send a chat prompt", description = "Forwards the prompt to the configured OpenAI model and returns its reply.")
    public String chat(@RequestBody ChatMessage message) {
        return chatClient.prompt(message.message())
                .call()
                .content();
    }
}
