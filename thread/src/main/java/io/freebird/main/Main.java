package io.freebird.main;

/**
 * @author freebird
 * @date 2020/4/19 19:06
 */
public class Main {
    private static boolean isEmpty = true;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        while (true){
            test();
        }
    }

    private static void test() {
        synchronized (LOCK) {
            while (isEmpty) {
                System.out.println("生产者生产好了");
                isEmpty = false;
                LOCK.notifyAll();
            }
        }
        synchronized (LOCK) {
            while (!isEmpty) {
                System.out.println("消费好了");
                isEmpty = true;
            }
        }

    }


}
