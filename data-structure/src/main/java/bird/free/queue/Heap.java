package bird.free.queue;

/**
 * 堆/优先队列的简单实现
 *
 * @author: zhouziyan
 * @Date: 2019/6/14 15:30
 */
public class Heap {

    private final Integer[] queue;

    private int size = 0;

    public Heap(int capacity) {
        this.queue = new Integer[capacity];
    }


    public void enter(Integer ele) {
        if (ele == null) {
            throw new NullPointerException("the enter element cannot be null");
        }
        if (size == 0) {
            queue[0] = ele;
            size++;
        } else {
            // 调整堆的结构.
            int temp = size;
            queue[size++] = ele;
            // 父节点下标为子节点的1/2
            while (temp > 0) {
                // 0,1,2,3,4....
                int parent = (temp - 1) / 2;
                Integer tempNode = queue[parent];
                // 不需要调整
                if (queue[temp] > queue[parent]) {
                    break;
                }
                queue[parent] = queue[temp];
                queue[temp] = tempNode;
                temp = parent;
            }
        }
    }

    /**
     * 要保证完全二叉树的特性
     * 又要保证堆的特性
     * 把数组最后的元素放到堆顶,向下调整
     * 向下调整的方式
     *
     * @return
     */
    public Integer poll() {
        Integer returnNode = queue[0];
        int temp = 0;
        queue[temp] = queue[--size];
        while (temp < size) {
            int leftChild = (temp + 1) * 2 - 1;
            int rightChild = (temp + 1) * 2;
            Integer tempNode = queue[temp];
            if (queue[leftChild] < queue[temp]) {
                queue[temp] = queue[leftChild];
                queue[leftChild] = tempNode;
            }
            if (queue[rightChild] < queue[temp]) {
                queue[temp] = queue[rightChild];
                queue[rightChild] = tempNode;
            }
            if (queue[leftChild] > queue[rightChild]) {
                temp = leftChild;
            } else {
                temp = rightChild;
            }
        }

        return returnNode;
    }


}
