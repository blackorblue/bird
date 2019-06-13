package bird.free.demo;

import bird.free.Task;
import bird.free.utils.ThreadUtils;

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
