package me.nzuguem.something.story.resources;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.nzuguem.something.story.business.llm.SomethingStoryAI;

@Path("something/story")
@RunOnVirtualThread
public class SomethingStoryResource {

    private final SomethingStoryAI somethingStoryAI;

    public SomethingStoryResource(SomethingStoryAI somethingStoryAI) {
        this.somethingStoryAI = somethingStoryAI;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ask(@Nonnull @QueryParam("message") String message) {
        return this.somethingStoryAI.ask(message);
    }
}
