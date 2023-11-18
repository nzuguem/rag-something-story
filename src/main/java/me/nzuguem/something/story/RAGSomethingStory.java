package me.nzuguem.something.story;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import me.nzuguem.something.story.configurations.langchain.Ingestor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class RAGSomethingStory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RAGSomethingStory.class);


    void onStartup(@Observes StartupEvent __, Ingestor ingestor) {

        LOGGER.info("Ingesting documents for RAG");

        ingestor.ingest();
    }
}
