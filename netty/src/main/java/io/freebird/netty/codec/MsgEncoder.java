package io.freebird.netty.codec;

import io.freebird.netty.domain.Msg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

/**
 * 自定义消息编码
 */
public class MsgEncoder extends MessageToByteEncoder<Msg> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf out) throws Exception {
        out.writeByte(msg.getContent().getBytes().length);
        out.writeBytes(msg.getContent().getBytes(CharsetUtil.UTF_8));
    }
}
