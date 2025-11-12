package com.example;
 

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {
    private static Set<Session> users = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        users.add(session);
        System.out.println("New user connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (Session user : users) {
            if (user.isOpen()) {
                user.getBasicRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        users.remove(session);
        System.out.println("User disconnected: " + session.getId());
    }
}