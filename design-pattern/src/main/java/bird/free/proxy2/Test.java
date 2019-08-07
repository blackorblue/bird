package bird.free.proxy2;

import bird.free.proxy.PersonallyRentingHouse;

public class Test {

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonallyRentingHouse());
    }
}
