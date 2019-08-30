package bird.free.netty.codec;

import bird.free.netty.domain.Msg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

public class MsgDecoder extends ReplayingDecoder<Msg> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 写入数据的长度
        int len = in.readByte() & 0xff;

        byte[] data = new byte[len];
        // 将数据写入data数组中
        in.readBytes(data);

        Msg message = Msg.builder()
                .content(new String(data, CharsetUtil.UTF_8))
                .build();
        out.add(message);
    }
}
