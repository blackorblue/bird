package io.freebird.netty.demo.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class ByteBufSliceDemo {

    public static void main(String[] args) {
        Charset utf8 = CharsetUtil.UTF_8;
        ByteBuf byteBuf = Unpooled.copiedBuffer("wo shi ni baba!", utf8);
        ByteBuf sliceBuf = byteBuf.slice(0, 10);
        System.out.println(sliceBuf.toString(utf8));
        ByteBuf b = byteBuf.setByte(0, 'J');// 替换index为0的bytebuf
        System.out.println(sliceBuf.toString(utf8));
        System.out.println(b.getByte(0) == byteBuf.getByte(0)); ;
    }
}
