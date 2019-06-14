package bird.free.concurrent.demo;

import bird.free.concurrent.utils.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhouziyan
 * @Date: 2019/6/13 17:33
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        ThreadFactory threadFactory = ThreadUtils.createThreadFactory("my-thread");
        ExecutorService executorService = ThreadUtils.createThreadPool(5, 10, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5), threadFactory);
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()));
    }
}
