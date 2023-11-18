package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.retriever.Retriever;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RetrieverModel implements Retriever<TextSegment> {

    private final EmbeddingStoreRetriever retriever;

    public RetrieverModel(ChromaEmbeddingStore chromaEmbeddingStore, EmbeddingModel embeddingModel) {
        retriever = EmbeddingStoreRetriever.from(chromaEmbeddingStore, embeddingModel, 20);
    }

    @Override
    public List<TextSegment> findRelevant(String text) {
        return this.retriever.findRelevant(text);
    }
}
