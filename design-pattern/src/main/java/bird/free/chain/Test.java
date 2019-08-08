package bird.free.chain;

public class Test {

    public static void main(String[] args) {
        AbstractHandler handler1 = new FirstHandler(1);
        AbstractHandler handler2 = new SecondHandler(2);
        AbstractHandler handler3 = new ThirdHandler(3);
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler1.handle(3);
    }
}
