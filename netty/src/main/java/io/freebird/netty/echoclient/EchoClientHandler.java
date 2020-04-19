package io.freebird.netty.echoclient;

import io.freebird.netty.constant.ChatConstants;
import io.freebird.netty.domain.Msg;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<Msg> {

    /**
     * 当从服务器接收到一条消息时会调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        System.out.println("client received:"+msg.getContent());
        if(msg.getContent().equals(ChatConstants.C1)){
            ctx.writeAndFlush(Msg.builder().content(ChatConstants.S1).build());
        }else if(msg.getContent().equals(ChatConstants.C2)){
            ctx.writeAndFlush(Msg.builder().content(ChatConstants.S2).build());
        }else if(msg.getContent().equals(ChatConstants.C3)){
            ctx.writeAndFlush(Msg.builder().content(ChatConstants.S3).build());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("netty go!", CharsetUtil.UTF_8));
    }
}
