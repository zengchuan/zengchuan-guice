package com.zeng.servlet;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Joiner.on;
import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;

public class TestResourceModule extends JerseyServletModule {
    @Override
    protected void configureServlets() {
        bind(TestResource.class);
        bind(GuiceContainer.class);
        //serve("/test").with(GuiceContainer.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put(PROPERTY_PACKAGES, "com.zeng.servlet");

        serve("/api/*").with(GuiceContainer.class, params);
    }
}
