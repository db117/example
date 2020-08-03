/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.db117.example.websocket.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 处理消息
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    private Map<String, ChannelHandlerContext> clients = new ConcurrentHashMap<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        clients.put(((InetSocketAddress) (ctx.channel().remoteAddress())).getHostName(), ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        clients.remove(ctx.channel().remoteAddress().toString());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // ping and pong frames already handled
        log.info(this.toString());
        if (frame instanceof TextWebSocketFrame) {
            String msg = ((TextWebSocketFrame) frame).text();
            log.info("服务端收到消息->[{}]", msg);
        } else {
            String message = "unsupported frame type: " + frame.getClass().getName();
            throw new UnsupportedOperationException(message);
        }
    }


    private void putCtx(ChannelHandlerContext ctx) {
        String address = ((InetSocketAddress) (ctx.channel().remoteAddress())).getAddress().getHostAddress();

        clients.put(address, ctx);
        log.info("添加客户端->[{}]", address);
    }

    private void removeCtx(ChannelHandlerContext ctx) {
        String address = ((InetSocketAddress) (ctx.channel().remoteAddress())).getAddress().getHostAddress();
        clients.remove(address);
        log.info("移除客户端->[{}]", address);
    }

    /**
     * 发生消息
     *
     * @param clientIp 客户端ip
     * @param msg      消息
     */
    public void sendMsg(String clientIp, String msg) {
        ChannelHandlerContext context = clients.get(clientIp);
        if (context != null) {
            context.channel().writeAndFlush(new TextWebSocketFrame(msg));
        } else {
            log.warn("未找到客户端,clientIp->[{}]", clientIp);
        }
    }
}

