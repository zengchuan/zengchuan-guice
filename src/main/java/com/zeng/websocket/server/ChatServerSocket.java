package com.zeng.websocket.server;

import com.google.inject.Singleton;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint("/chat")
public class ChatServerSocket {

    private static final Map<Socket, String> socketSet = Collections.synchronizedMap(new HashMap<Socket, String>());

    @OnOpen
    public void onOpen(Session session) {
        Socket socket = new Socket(session);
        socketSet.put(socket, null);
        System.out.println(session.toString());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("size1=" + socketSet.size());
        Socket key = new Socket(session);
        String name =  socketSet.get(key);
        if(name == null){
            name = message;
            socketSet.remove(key);
            socketSet.put(key, name);
            sendAllMessage(name + "进入！");
        } else {
            sendAllMessage(name + ":" + message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        String name =  socketSet.get(new Socket(session));
        socketSet.remove(new Socket(session));
        sendAllMessage(name + "离开！");
    }

    private void sendAllMessage(String message){
        System.out.println("message=" + message);
        System.out.println("size=" + socketSet.size());
        for(Socket socket : socketSet.keySet()){
            sendMessage(message, socket);
        }
    }

    private void sendMessage(String message, Socket socket){
        try {
            socket.send(message);
        } catch (IOException e) {
            try {
                socketSet.remove(socket);
                socket.getSession().close();
            } catch (IOException e1) {
            }
        }
    }

}
