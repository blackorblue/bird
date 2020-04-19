package io.freebird.singleton;

/**
 * @author freebird
 * 饿汉模式：在编译的时候就加载对象
 */
public class SingletonV1 {

    private final static SingletonV1 INSTANCE = new SingletonV1();

    private SingletonV1(){}

    public static SingletonV1 getInstance(){
        return INSTANCE;
    }
}
