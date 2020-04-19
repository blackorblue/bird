package io.freebird.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhouziyan
 * @date 2019/6/13 15:58
 */
public class TaskWrapper implements Runnable {

    private Task task;

    private CountDownLatch cdl;

    private List<Exception> runtimeExceptions;

    private long expireTime;

    private TaskWrapper(Builder builder) {
        this.task = builder.task;
        this.cdl = builder.cdl;
        this.runtimeExceptions = builder.runtimeExceptions;
    }

    private TaskWrapper() {
    }

    public static class Builder {
        private Task task;

        private CountDownLatch cdl;

        private List<Exception> runtimeExceptions;

        public Builder withTask(Task task) {
            this.task = task;
            return this;
        }

        public Builder withCountDownLatch(CountDownLatch cdl) {
            this.cdl = cdl;
            return this;
        }

        public Builder withExceptionsMayThrow(List<Exception> runtimeExceptions) {
            this.runtimeExceptions = runtimeExceptions;
            return this;
        }

        public TaskWrapper build() {
            return new TaskWrapper(this);
        }
    }


    public TaskWrapper setExpireTime(long time) {
        this.expireTime = time;
        return this;
    }

    @Override
    public void run() {
        try {
            task.go();
        } catch (Exception e) {
            runtimeExceptions.add(e);
        } finally {
            cdl.countDown();
        }
    }
}
