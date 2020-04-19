package io.freebird.queue.demo;


import io.freebird.queue.BlockingQueue;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouziyan
 * @date 2019/6/24 16:24
 */
public class BlockingQueueDemo {


    public static void main(String[] args)  {
        final BlockingQueue queue = new BlockingQueue(10);
        ExecutorService enterThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService pollThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 11; i++) {
            final int finalI = i;
            enterThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        queue.enter(finalI);
                    } catch (InterruptedException e) {

                    }
                }
            });
            pollThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
