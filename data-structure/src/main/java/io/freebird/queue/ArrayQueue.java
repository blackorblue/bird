package io.freebird.queue;


/**
 * @author: zhouziyan
 * @date: 2019/6/14 11:43
 */
public class ArrayQueue<T> {

    private final Object[] queue;

    private int size = 0;

    public ArrayQueue(int capacity) {
        this.queue = new Object[capacity];
    }

    /**
     * 进队
     *
     * @param t 进队元素
     */
    public void enter(T t) {
        if (t == null) {
            throw new NullPointerException("the add element cannot be null");
        }
        if (size >= queue.length) {
            pollFirst();
            queue[queue.length - 1] = t;
        }else {
            queue[size++] = t;
        }
    }

    /**
     * 出队
     */
    public T poll() {
        return pollFirst();
    }

    public T pollFirst() {
        if (size == 0) {
            throw new NullPointerException("no element in this queue");
        }
        T ele = (T) queue[0];
        for (int i = 0, len = queue.length; i < len; i++) {
            if (i == len - 1) {
                queue[i] = null;
                break;
            }
            queue[i] = queue[i + 1];
        }
        return ele;
    }


    public int size() {
        return queue.length;
    }


    public T get(int index) {
        return (T) queue[index];
    }

}
