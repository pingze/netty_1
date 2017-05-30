package com.zpyin.netty.heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Created by zpyin on 2017/5/30.
 */
public class MyHeartbeatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new IdleStateHandler(5, 7, 10, TimeUnit.SECONDS))
                    .addLast(new MyHeartbeatServerHandler());
    }
}
