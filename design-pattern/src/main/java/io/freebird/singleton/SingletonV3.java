package io.freebird.singleton;


/**
 * @author freebird
 */
public class SingletonV3 {


    public SingletonV3 getInstance(){

        return Instance.instance;
    }

    static class Instance{
        static SingletonV3 instance = new SingletonV3();
    }
}

