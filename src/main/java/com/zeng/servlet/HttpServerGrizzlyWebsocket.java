package com.zeng.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.zeng.websocket.server.ChatServerSocket;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.tyrus.container.grizzly.GrizzlyEngine;
import org.glassfish.tyrus.server.TyrusServerContainer;
import org.glassfish.tyrus.spi.TyrusContainer;
import org.glassfish.tyrus.spi.TyrusServer;

import javax.websocket.Extension;
import javax.websocket.server.ServerEndpointConfig;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpServerGrizzlyWebsocket {


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


        String rootWebSocketsPath = "";
        String webappDirLocation = "src/main/webapp/";
        String absolutePath = new File(webappDirLocation).getAbsolutePath();
        GrizzlyEngine grizzlyEngine = new GrizzlyEngine();
        TyrusServer tyrusServer = grizzlyEngine.createServer(absolutePath, 8070);
        HttpServer httpServer = grizzlyEngine.getServer();

        Set<Class<?>> scanned = new HashSet<Class<?>>() {{
            add(ChatServerSocket.class);
        }};

        TyrusServerContainer server = new TyrusServerContainer(tyrusServer, rootWebSocketsPath,
                scanned, Collections.<Class<?>>emptySet(),
                Collections.<ServerEndpointConfig>emptySet());
        server.start();

        WebappContext context = createWebappContext("/");
        context.deploy(httpServer);

        System.in.read();
        server.stop();
        System.exit(0);

    }

    private static final WebappContext createWebappContext(String path) {
        if ("/".equals(path)) path = ""; //In order for Guice to work ok

        WebappContext context = new WebappContext("grizzly-context", path);

        context.addFilter(GuiceFilter.class.getName(), GuiceFilter.class)
                .addMappingForUrlPatterns(null, "/*");


        return context;
    }

}
