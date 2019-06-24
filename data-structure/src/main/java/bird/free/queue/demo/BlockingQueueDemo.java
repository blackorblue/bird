package bird.free.queue.demo;

import bird.free.queue.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouziyan
 * @date 2019/6/24 16:24
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        final BlockingQueue<Integer> queue = new BlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> queue.enter(i);
            executorService.submit(() -> queue.enter(i), null);
        }*/
    }
}
