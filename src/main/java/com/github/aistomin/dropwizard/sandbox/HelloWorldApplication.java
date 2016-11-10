package com.github.aistomin.dropwizard.sandbox;

import com.github.aistomin.dropwizard.sandbox.health.TemplateHealthCheck;
import com.github.aistomin.dropwizard.sandbox.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by aistomin on 10/11/2016.
 * <p>
 * Combined with your project's Configuration subclass, its Application subclass
 * forms the core of your Dropwizard application. The Application class pulls
 * together the various bundles and commands which provide basic functionality.
 */
public final class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(
        final HelloWorldConfiguration configuration,
        final Environment environment
    ) {
        environment.healthChecks().register(
            "template", new TemplateHealthCheck(configuration.getTemplate())
        );
        environment.jersey().register(
            new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
            )
        );
    }
}
