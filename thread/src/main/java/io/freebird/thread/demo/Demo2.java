package io.freebird.thread.demo;

import io.freebird.thread.Task;
import io.freebird.util.ThreadUtils;

import java.util.ArrayList;

/**
 * @author: zhouziyan
 * @date: 2019/6/13 18:23
 */
public class Demo2{

    public static void main(String[] args) throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        Task task = ()-> System.out.println("试试..");
        Task task1 = () -> System.out.println(1/0);
        Task task2 = ()-> System.out.println("会中断么");
        tasks.add(task);
        tasks.add(task1);
        tasks.add(task2);
        ThreadUtils.doAnyAysncTask(tasks);
    }
}
