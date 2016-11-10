package com.github.aistomin.dropwizard.sandbox.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by aistomin on 10/11/2016.
 * <p>
 * The id field is a unique identifier for the saying, and content is the
 * textual representation of the saying.
 */
public final class Saying {

    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
    }

    public Saying(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
