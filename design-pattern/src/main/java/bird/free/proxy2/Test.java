package bird.free.proxy2;

import bird.free.proxy.PersonallyRentingHouse;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonallyRentingHouse());
       // Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),{},)
    }
}
