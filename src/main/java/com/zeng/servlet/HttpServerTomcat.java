package com.zeng.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.zeng.websocket.server.ChatServerSocket;
import org.apache.catalina.Context;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.WsListener;
import org.apache.tomcat.websocket.server.WsServerContainer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerContainerProvider;
import java.io.File;
import java.util.EnumSet;

public class HttpServerTomcat {


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

        Tomcat tomcat= new Tomcat();
        tomcat.setPort(8090);
        String webappDirLocation = "src/main/webapp/";
        Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        context.addApplicationListener(Config.class.getName());

//        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

//        String appBase = ".";
//        tomcat.setBaseDir("webapp");
//        tomcat.getHost().setAppBase(appBase);
//        String contextPath = "/";
//        StandardServer server = (StandardServer)tomcat.getServer();
//        AprLifecycleListener listener = new AprLifecycleListener();
//        server.addLifecycleListener(listener);
//        Context context = tomcat.addWebapp(contextPath, appBase);

        context.addFilterDef(createFilterDef("guiceFilter", injector.getInstance(GuiceFilter.class)));
        context.addFilterMap(createFilterMap("guiceFilter", "/*"));


        tomcat.enableNaming();
        tomcat.init();


        tomcat.start();
        tomcat.getServer().await();

    }

    private static FilterDef createFilterDef(String filterName, Filter filter) {
        FilterDef filterDef = new FilterDef();
        filterDef.setFilterName(filterName);
        filterDef.setFilter(filter);
        return filterDef;
    }

    private static FilterMap createFilterMap(String filterName, String urlPattern) {
        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName(filterName);
        filterMap.addURLPattern(urlPattern);
        return filterMap;
    }


    public static class Config extends WsListener {

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            super.contextInitialized(sce);
            WsServerContainer sc = WsServerContainer.getServerContainer();
            try {
                sc.addEndpoint(ChatServerSocket.class);
            } catch (DeploymentException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
