package io.freebird.queue.demo;


import io.freebird.queue.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouziyan
 * @date 2019/6/24 16:24
 */
public class BlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue queue = new BlockingQueue(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 11; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        queue.enter(finalI);
                    } catch (InterruptedException e) {

                    }
                }
            });
        }
        Thread.sleep(1000L);
        System.out.println(queue.poll());
    }
}
