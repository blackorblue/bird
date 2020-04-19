package io.freebird.queue.demo;

import io.freebird.queue.ArrayQueue;

/**
 * @author: zhouziyan
 * @review:
 * @date: 2019/6/14 12:19
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(5);
        arrayQueue.enter(1);
        arrayQueue.enter(2);
        arrayQueue.enter(3);
        arrayQueue.enter(4);
        arrayQueue.enter(5);
        arrayQueue.enter(6);
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.get(0));
        System.out.println(arrayQueue.get(1));
        System.out.println(arrayQueue.get(2));
        System.out.println(arrayQueue.get(3));
        System.out.println(arrayQueue.get(4));
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.get(4));
    }
}
