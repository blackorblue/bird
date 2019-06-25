package bird.free.tree;

/**
 * @author zhouziyan
 * @date 2019/6/24 17:41
 */
public class BinarySearchTree<E> {


    private int depth;

    private int height;

    private Node<E> head;

    public void add(E e) {
        final Node<E> enterNode = new Node(e);
        if (head == null) {
            // 头节点
            head = enterNode;
            return;
        }
        addLast(e);

    }

    private void addLast(E e) {

    }


    private static class Node<E> {

        Node left;
        Node right;
        Node parent;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }
}
