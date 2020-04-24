package io.freebird.isolateInteface;

/**
 * @author freebird
 * @date 2020/4/24 21:32
 */
public class EnCodeDemo {

    public static void main(String[] args) {
        Encoder defaultEncoder = new DefaultCodec();
        defaultEncoder.encode("把我编了");
    }
}
