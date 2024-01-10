package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URL;
import java.util.List;

@ApplicationScoped
public class Ingestor {

    @ConfigProperty(name = "rag.something.story.documents.sources")
    private List<URL> documentsSources;

    // The embedding store (the database)
    private final ChromaEmbeddingStore embeddingStore;


    // The embedding model (how is computed the vector of a document)
    private final EmbeddingModel embeddingModel;

    public Ingestor(ChromaEmbeddingStore embeddingStore, EmbeddingModel embeddingModel) {
        this.embeddingStore = embeddingStore;
        this.embeddingModel = embeddingModel;
    }

    public void ingest() {

        var documents = this.loadDocuments();

        var ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .documentSplitter(DocumentSplitters.recursive(100, 0))
                .build();

        ingestor.ingest(documents);
    }

    private List<Document> loadDocuments() {

        return this.documentsSources.stream()
                .map(url -> UrlDocumentLoader.load(url, new TextDocumentParser()))
                .toList();
    }
}
