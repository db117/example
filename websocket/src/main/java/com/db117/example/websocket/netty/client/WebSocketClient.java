package com.db117.example.websocket.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 启动客户端
 *
 * @author db117
 * @date 2020/6/5/005
 **/
@Slf4j
@Component
public class WebSocketClient implements ApplicationListener<ApplicationReadyEvent>, Runnable {
    @Autowired
    private WebSocketClientHandler webSocketClientHandler;
    private String serverUrl = "ws://127.0.0.1:8888/websocket";

    private EventLoopGroup group = new NioEventLoopGroup();


    @Override
    public void onApplicationEvent(@Nullable ApplicationReadyEvent event) {

        new Thread(this).start();
    }

    @Override
    public void run() {

        try {
            URI uri = new URI(serverUrl);
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(
                                    new HttpClientCodec(),
                                    new HttpObjectAggregator(8192),
                                    WebSocketClientCompressionHandler.INSTANCE,
                                    new IdleStateHandler(10, 0, 0),
                                    webSocketClientHandler);
                        }
                    });


            ChannelFuture channelFuture = b.connect(uri.getHost(), uri.getPort())
                    .addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            System.out.println("服务端链接成功");
                            return;
                        }
                        System.out.println("服务端链接不上，开始重连操作...");
                        run();
                        Thread.sleep(5*1000);
                    });

            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException | URISyntaxException e) {
            log.warn(e.getMessage(), e);
        } finally {
//            group.shutdownGracefully();
        }
    }
}
