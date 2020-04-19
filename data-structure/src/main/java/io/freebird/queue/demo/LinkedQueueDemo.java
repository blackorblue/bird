package io.freebird.queue.demo;

import io.freebird.queue.LinkedQueue;

/**
 * @author: zhouziyan
 * @review:
 * @date: 2019/6/14 15:15
 */
public class LinkedQueueDemo {

    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue();
        linkedQueue.enter(1);
        linkedQueue.enter(2);
        linkedQueue.enter(3);
        linkedQueue.enter(4);
        linkedQueue.enter(5);
        System.out.println(linkedQueue.getHead());
        System.out.println(linkedQueue.getTail());
    }
}
