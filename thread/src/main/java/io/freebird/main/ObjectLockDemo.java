package io.freebird.main;

import java.util.concurrent.CompletableFuture;

/**
 * @author freebird
 * @date 2020/4/19 19:06
 */
public class ObjectLockDemo {
    private boolean isEmpty = false;
    private final Object LOCK = new Object();

    public static void main(String[] args) {
        ObjectLockDemo demoObject = new ObjectLockDemo();
        demoObject.consume();
        demoObject.provide();

    }

    public void provide() {
        CompletableFuture.runAsync(() -> {
            synchronized (LOCK) {
                // 当不为空的时候就挂起
                while (!isEmpty) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("正在生产");
                isEmpty = false;
                LOCK.notifyAll();
            }
        });
    }


    public void consume() {
        CompletableFuture.runAsync(() -> {
            synchronized (LOCK) {
                while (isEmpty){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("正在消费");
                isEmpty = true;

                LOCK.notify();
            }
        });

    }

}
