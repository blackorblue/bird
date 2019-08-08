package chain;

public class Test {

    public static void main(String[] args) {
        AbstractHandler handler1 = new FirstHandler(1);
        AbstractHandler handler2 = new SecondHandler(2);
        handler1.setNextHandler(handler2);
        handler1.handle(1);
    }
}
