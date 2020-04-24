package io.freebird.isolateInteface;

/**
 * @author freebird
 * @date 2020/4/24 21:29
 * 编解码
 */
public interface Encoder {

    Byte[] encode(String src);
}
