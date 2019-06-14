package bird.free.concurrent;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/13 15:58
 */
public class TaskWrapper implements Runnable {

    private final Task task;

    private final CountDownLatch cdl;


    private final List<Exception> runtimeExceptions;

    private TaskWrapper(Task task, CountDownLatch cdl,List<Exception> runtimeExceptions) {
        this.task = task;
        this.cdl = cdl;
        this.runtimeExceptions = runtimeExceptions;
    }

    public static TaskWrapper builder(Task task, CountDownLatch cdl,List<Exception> runtimeExceptions) {
        return new TaskWrapper(task, cdl,runtimeExceptions);
    }

    public TaskWrapper build() {
        return this;
    }


    @Override
    public void run(){
        try {
            task.go();
        } catch (Exception e) {
            runtimeExceptions.add(e);
        } finally {
            cdl.countDown();
        }
    }
}
