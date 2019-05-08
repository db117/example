package com.db117.example.websocket;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author db117
 * @date 2019/5/8
 **/
@Slf4j
@ServerEndpoint(value = "/testWebsocket")
@Component
@EqualsAndHashCode
public class Socket {
    /**
     * 用来记录当前连接数的变量
     */
    private static volatile int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
     */
    private static CopyOnWriteArraySet<Socket> webSocketSet = new CopyOnWriteArraySet<Socket>();

    /**
     * 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
     */
    private Session session;

    @OnOpen
    public void onOpen(Session session) throws Exception {
        this.session = session;
        System.out.println(this.session.getId());
        webSocketSet.add(this);
        log.info("Open a websocket");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("Close a websocket. ");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        session.getAsyncRemote().sendText("66666666");
        log.info("Receive a message from client: " + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Error while websocket. ", error);
    }

    public void sendMessage(String message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText("Send a message from server. ");
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
