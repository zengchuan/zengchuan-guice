package com.zeng.websocket.server;

import javax.websocket.Session;
import java.io.IOException;

public class Socket {
    private Session session;

    public Socket(Session session) {
        this.session = session;
    }

    public void send(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    public Session getSession() {
        return session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socket socket = (Socket) o;

        if (session != null ? !session.equals(socket.session) : socket.session != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return session != null ? session.hashCode() : 0;
    }
}
