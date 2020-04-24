package io.freebird.isolateInteface;

/**
 * @author freebird
 * @date 2020/4/24 21:33
 */
public class DecodeDemo {

    public static void main(String[] args) {
        Decoder decoder = new DefaultCodec();
        decoder.decode(new Byte[1]);
    }
}
