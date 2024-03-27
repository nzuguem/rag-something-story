package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.query.Metadata;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StoryRetrievalAugmentor implements RetrievalAugmentor {

    private final RetrievalAugmentor retrievalAugmentor;

    public StoryRetrievalAugmentor(StoryContentRetriever retriever) {
        this.retrievalAugmentor = DefaultRetrievalAugmentor.builder()
                .contentRetriever(retriever)
                .build();
    }


    @Override
    public UserMessage augment(UserMessage userMessage, Metadata metadata) {
        return this.retrievalAugmentor.augment(userMessage, metadata);
    }
}
