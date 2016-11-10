package com.github.aistomin.dropwizard.sandbox.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.aistomin.dropwizard.sandbox.api.Saying;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by aistomin on 10/11/2016.
 * <p>
 * Jersey resources are the meat-and-potatoes of a Dropwizard application. Each
 * resource class is associated with a URI template. For our application, we
 * need a resource which returns new Saying instances from the URI /hello-world
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public final class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(final String template, final String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(final @QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
