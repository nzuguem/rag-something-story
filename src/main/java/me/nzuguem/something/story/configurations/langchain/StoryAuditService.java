package me.nzuguem.something.story.configurations.langchain;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.output.Response;
import io.quarkiverse.langchain4j.audit.Audit;
import io.quarkiverse.langchain4j.audit.AuditService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StoryAuditService implements AuditService {


    @Override
    public Audit create(Audit.CreateInfo createInfo) {
        Log.infof("Audit create - %s", createInfo);
        return new AuditImpl(createInfo);
    }

    @Override
    public void complete(Audit audit) {
        Log.infof("Audit complete - %s", audit);
    }

    private static class AuditImpl extends Audit {

        public AuditImpl(CreateInfo createInfo) {
            super(createInfo);
        }

        @Override
        public void initialMessages(Optional<SystemMessage> systemMessage, UserMessage userMessage) {
            Log.infof("""
                    initialMessages
                    systemMessage - %s
                    userMessage - %s
                    """, systemMessage, userMessage);
        }

        @Override
        public void addRelevantDocument(List<TextSegment> segments, UserMessage userMessage) {
            Log.infof("""
                    addRelevantDocument
                    segments - %s
                    userMessage - %s
                    """, segments, userMessage);
        }

        @Override
        public void addLLMToApplicationMessage(Response<AiMessage> response) {
            Log.infof("addLLMToApplicationMessage - %s", response);
        }

        @Override
        public void addApplicationToLLMMessage(ToolExecutionResultMessage toolExecutionResultMessage) {
            Log.infof("addApplicationToLLMMessage - %s", toolExecutionResultMessage);
        }

        @Override
        public void onCompletion(Object result) {
            Log.infof("onCompletion - %s", result);
        }

        @Override
        public void onFailure(Exception e) {
            Log.errorf(e,"onFailure");
        }
    }
}
