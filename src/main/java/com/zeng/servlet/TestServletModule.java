package com.zeng.servlet;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class TestServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(TestServlet.class);
        serve("/testServlet").with(TestServlet.class);
    }
}
