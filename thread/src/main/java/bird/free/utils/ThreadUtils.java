package bird.free.utils;

import bird.free.Task;
import bird.free.TaskWrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/6 15:56
 */
public class ThreadUtils {

    private static final int DEFAULT_CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static final int DEFAULT_MAX_SIZE = Runtime.getRuntime().availableProcessors();

    private static final long DEFAULT_KEEP_ALIVE_TIME = 3000L;

    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;

    private static final BlockingQueue DEFAULT_BLOCKING_QUEUE = new LinkedBlockingDeque();

    /**
     * 使用ForkJoinPool作为默认线程池
     **/
    private static ExecutorService EXECUTOR_SERVICE;

    private static CompletionService completionService;

    private ThreadUtils() {
    }


    static {
        EXECUTOR_SERVICE = new ForkJoinPool();
        completionService = new ExecutorCompletionService(EXECUTOR_SERVICE);
    }

    /**
     * @param coreSize      线程池线程核心数量
     * @param maxSize       最大数量
     * @param keepAliveTime 保持活跃的时间,超过闲置的线程就被回收
     * @param timeUnit      时间单位
     * @param workingQueue  线程工作的阻塞队列
     * @param threadFactory 线程工厂
     * @return {@link ExecutorService}
     */
    public static ExecutorService createThreadPool(int coreSize, int maxSize, int keepAliveTime, TimeUnit timeUnit, BlockingQueue workingQueue, ThreadFactory threadFactory) {
        EXECUTOR_SERVICE = new ThreadPoolExecutor(coreSize, maxSize, keepAliveTime, timeUnit, workingQueue, threadFactory);
        return EXECUTOR_SERVICE;
    }


    /**
     * 批量执行异步任务
     *
     * @param callableList 带有返回值的任务对象
     * @param <V>          线程执行了之后得到的结果
     * @return Future集合, 得到的结果与{@code callableList}添加的顺序一致.
     */
    public static <V> List<Future<V>> doAnyAysncTaskWithFuture(Collection<? extends Callable<V>> callableList) throws InterruptedException {
        List<Future<V>> futures = new ArrayList<>(callableList.size());
        // futures里的顺序和callableList是一致的.
        for (Callable<V> callable : callableList) {
            Future submit = completionService.submit(callable);
            futures.add(submit);
        }
        return futures;
    }

    /**
     * 批量执行异步任务/主线程会阻塞等到异步任务执行完之后才会执行
     * 如果有一个线程发生了异常,主线程会阻塞不会执行
     *
     * @param tasks 任务的集合
     * @throws InterruptedException
     */
    public static void doAnyAysncTask(Collection<? extends Task> tasks) throws Exception {
        if (CollectionUtils.isEmpty(tasks)) {
            return;
        }
        CountDownLatch cdl = new CountDownLatch(tasks.size());
        List<Exception> exceptions = new ArrayList();
        // futures里的顺序和callableList是一致的.
        for (Task task : tasks) {
            TaskWrapper taskWrapper = TaskWrapper.builder(task, cdl, exceptions).build();
            completionService.submit(taskWrapper, null);
        }
        cdl.await();
        if (!exceptions.isEmpty()) {
            // 抛出其中的第一个异常
            throw exceptions.stream()
                    .findFirst()
                    .get();
        }
    }

    /**
     * 创建带有指定名称的线程
     *
     * @param threadName 线程名称
     * @return 线程工厂, 用于创建线程池
     */
    public static ThreadFactory createThreadFactory(String threadName) {
        return new MyThreadFactory(threadName);
    }

    private static class MyThreadFactory implements ThreadFactory {
        final Lock lock = new ReentrantLock();
        final String THREAD_NAME_PREFIX;
        int threadCount;
        final String THREAD_NAME_SEPARATOR = "-";

        public MyThreadFactory(String threadName) {
            this.THREAD_NAME_PREFIX = threadName;
        }

        @Override
        public Thread newThread(Runnable r) {
            try {
                lock.lock();
                String threadName = new StringBuilder()
                        .append(THREAD_NAME_PREFIX)
                        .append(THREAD_NAME_SEPARATOR)
                        .append(threadCount++)
                        .toString();
                return new Thread(r, threadName);
            } finally {
                lock.unlock();
            }
        }
    }
}
