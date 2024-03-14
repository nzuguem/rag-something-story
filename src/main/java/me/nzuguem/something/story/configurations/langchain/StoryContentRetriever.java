package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.rag.query.Query;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class StoryContentRetriever implements ContentRetriever {

    private final EmbeddingStoreContentRetriever retriever;

    public StoryContentRetriever(ChromaEmbeddingStore chromaEmbeddingStore, EmbeddingModel embeddingModel) {
        this.retriever = EmbeddingStoreContentRetriever.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(chromaEmbeddingStore)
                .maxResults(20)
                .build();
    }

    @Override
    public List<Content> retrieve(Query query) {
        return this.retriever.retrieve(query);
    }
}
