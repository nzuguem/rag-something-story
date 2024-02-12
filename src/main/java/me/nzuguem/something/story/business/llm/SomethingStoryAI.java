package me.nzuguem.something.story.business.llm;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import me.nzuguem.something.story.configurations.langchain.RetrieverModel;

@RegisterAiService(
        retriever = RetrieverModel.class
)
public interface SomethingStoryAI {

    String ask(@UserMessage String prompt);
}
