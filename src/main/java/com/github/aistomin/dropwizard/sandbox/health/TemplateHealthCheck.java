package com.github.aistomin.dropwizard.sandbox.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by aistomin on 10/11/2016.
 *
 * Health checks give you a way of adding small tests to your application to
 * allow you to verify that your application is functioning correctly in
 * production. We strongly recommend that all of your applications have at least
 * a minimal set of health checks.
 */
public final class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(final String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
