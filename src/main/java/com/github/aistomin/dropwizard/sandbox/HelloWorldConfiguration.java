package com.github.aistomin.dropwizard.sandbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by aistomin on 10/11/2016.
 * <p>
 * The application we'll be building is a high-performance Hello World service,
 * and one of our requirements is that we need to be able to vary how it says
 * hello from environment to environment. We'll need to specify at least two
 * things to begin with: a template for saying hello and a default name to use
 * in case the user doesn't specify their name.
 */
final class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(final String template) {
        this.template = template;
    }

    @JsonProperty
    String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(final String name) {
        this.defaultName = name;
    }
}
