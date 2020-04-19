package io.freebird.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhouziyan
 * @date: 2019/6/14 10:23
 */
public class MyThreadFactory implements ThreadFactory {

    private final String THREAD_NAME_PREFIX;
    private final boolean daemon;
    private final AtomicInteger threadCount = new AtomicInteger(1);


    public MyThreadFactory(String threadName, boolean daemon) {
        this.THREAD_NAME_PREFIX = threadName;
        this.daemon = daemon;
    }

    public MyThreadFactory(String threadNamePrefix) {
        this(threadNamePrefix, false);
    }

    @Override
    public Thread newThread(Runnable r) {
        String threadName = THREAD_NAME_PREFIX + threadCount.getAndIncrement();
        Thread thread = new Thread(r, threadName);
        thread.setDaemon(daemon);
        return thread;
    }
}
