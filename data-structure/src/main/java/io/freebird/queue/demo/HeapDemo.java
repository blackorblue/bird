package io.freebird.queue.demo;

import io.freebird.queue.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zhouziyan
 */
public class HeapDemo {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        for (int i = 0; i < 10; i++) {
            heap.enter(10-i);
        }
       /* Integer[] array = heap.getArray();

        System.out.println(Arrays.toString(array));*/

        for (int i= 0; i <10 ; i++) {
            System.out.println(heap.poll());
        }
        PriorityQueue<Integer> queue = new PriorityQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.add(10-i);
        }
        for (int i= 0; i <10 ; i++) {
            System.out.println(queue.poll());
        }
        Object[] objects = queue.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
