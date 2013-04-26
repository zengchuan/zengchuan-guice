package com.zeng.websocket.server;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.common.base.Optional.of;

public class WebSocketEndPointServletJetty  extends HttpServlet {

//    private WebSocketServletFactory factory;
//
//    @Override
//    public void destroy() {
//        factory.cleanup();
//    }
//
//    @Override
//    public void init() throws ServletException {
//        WebSocketServletFactory baseFactory = new WebSocketFactory();
//
//        factory.register(Class.forName(value));
//
//        factory.init();
//    }
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (factory.isUpgradeRequest(request, response))
//            if (factory.acceptWebSocket(request, response) || response.isCommitted())
//                return;
//        super.service(request, response);
//    }
}
