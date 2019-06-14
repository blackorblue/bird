package bird.free.queue;

/**
 * 堆/优先队列的实现
 *
 * @author: zhouziyan
 * @Date: 2019/6/14 15:30
 */
public class Heap {

    private final Integer[] queue;

    public Heap(int capacity) {
        this.queue = new Integer[capacity];
    }


    public void enter(int ele) {
        if (queue[0] == null) {
            queue[0] = ele;
            return;
        }

    }


    public void poll() {

    }


}
