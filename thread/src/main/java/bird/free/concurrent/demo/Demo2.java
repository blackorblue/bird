package bird.free.concurrent.demo;

import bird.free.concurrent.Task;
import bird.free.concurrent.utils.ThreadUtils;

import java.util.ArrayList;

/**
 * @author: zhouziyan
 * @Date: 2019/6/13 18:23
 */
public class Demo2{

    public static void main(String[] args) throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        Task  task = ()-> System.out.println("试试..");
        tasks.add(task);
        ThreadUtils.doAnyAysncTask(tasks);
    }
}
