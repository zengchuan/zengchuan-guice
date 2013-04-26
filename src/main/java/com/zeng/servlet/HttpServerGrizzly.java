package com.zeng.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.zeng.websocket.server.ChatServerSocket;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.grizzly.servlet.WebappContext;

import java.io.File;
import java.io.IOException;

public class HttpServerGrizzly {


    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                binder().requireExplicitBindings();
                install(new TestResourceModule());
                install(new TestServletModule());
                bind(ChatServerSocket.class);
                bind(GuiceFilter.class);
            }
        });

        HttpServer server = startWebServer();
        System.out.println("Jersey started");

        System.in.read();
        server.stop();
        System.exit(0);
    }



    /**
     * Start the grizzly web container as described at
     * http://blog.msbbc.co.uk/2008/11/java-using-jersey-and-grizzly-to-create.html
     *
     * @return
     * @throws IOException
     */
    private static HttpServer startWebServer() throws IOException {

        HttpServer server = createHttpServer();

        WebappContext context = createWebappContext("/");
        context.deploy(server);

        return server;
    }

    private static final WebappContext createWebappContext(String path) {
        if ("/".equals(path)) path = ""; //In order for Guice to work ok

        WebappContext context = new WebappContext("grizzly-context", path);

        context.addFilter(GuiceFilter.class.getName(), GuiceFilter.class)
                .addMappingForUrlPatterns(null, "/*");


        return context;
    }

    // As per https://blogs.oracle.com/oleksiys/entry/grizzly_2_0_httpserver_api
    private static HttpServer createHttpServer() throws IOException {

        HttpServer server = HttpServer.createSimpleServer(null, 8090);

        String webappDirLocation = "src/main/webapp/";
        String absolutePath = new File(webappDirLocation).getAbsolutePath();

        server.getServerConfiguration()
                .addHttpHandler(
                        new StaticHttpHandler(absolutePath),
                        "/");


        server.start();

        return server;
    }
}
