package com.zpyin.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by zpyin on 2017/6/4.
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("zhangsan").setAge(11).setAddress("shanghai").build();
        ctx.channel().writeAndFlush(person);
    }
}
