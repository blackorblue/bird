package io.freebird.thread;
/**
 * @author: zhouziyan
 * @review:
 * @date: 2019/6/13 15:48
 */
@FunctionalInterface
public interface Task {


    void go() throws Exception;
}
