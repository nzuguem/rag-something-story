package me.nzuguem.something.story.business.llm;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface SomethingStoryAI {

    String ask(@UserMessage String prompt);
}
