package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Supplier;

@ApplicationScoped
public class StoryRetrievalAugmentor implements Supplier<RetrievalAugmentor> {

    private final StoryContentRetriever retriever;

    public StoryRetrievalAugmentor(StoryContentRetriever retriever) {
        this.retriever = retriever;
    }

    @Override
    public RetrievalAugmentor get() {
        return DefaultRetrievalAugmentor.builder()
                .contentRetriever(this.retriever)
                .build();
    }
}
