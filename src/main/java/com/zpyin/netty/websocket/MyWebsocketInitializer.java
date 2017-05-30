package com.zpyin.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by zpyin on 2017/5/30.
 */
public class MyWebsocketInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast(new HttpServerCodec())
                    .addLast(new ChunkedWriteHandler())
                    .addLast(new HttpObjectAggregator(8192))
                    .addLast(new WebSocketServerProtocolHandler("/ws"))  //ws:localhost:5999/ws
                    .addLast(new MyWebsocketHandler());

    }
}
