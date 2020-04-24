package io.freebird.isolateInteface;

/**
 * @author freebird
 * @date 2020/4/24 21:31
 */
public class DefaultCodec implements Decoder,Encoder {
    @Override
    public String decode(Byte[] data) {
        System.out.println("编码。。。");
        return null;
    }

    @Override
    public Byte[] encode(String src) {
        System.out.println("解码");
        return new Byte[0];
    }
}
