package bird.free.queue.demo;


import bird.free.queue.BlockingQueue;

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
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        queue.enter(finalI);
                    } catch (InterruptedException e) {

                    }
                }
            },null);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(queue.poll());
        }
    }
}
