package io.freebird.queue;


/**
 * 无界队列
 *
 * @author: zhouziyan
 * @Date: 2019/6/14 12:31
 */
public class LinkedQueue<E> {

    private Node head;
    private Node tail;

    private int size = 0;

    public void enter(E e) {
        if (e == null) {
            throw new NullPointerException("the enter element cannot be null");
        }
        final Node node = new Node(e);
        // 如果队列还没有元素
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            Node temp = tail;
            tail = node;
            node.prev = temp;
            temp.next = tail;
        }
        size++;
    }

    public E getHead() {
        return (E) head.get();
    }

    public E getTail() {
        return (E) tail.get();
    }

    public E poll() {
        return pollFirst();
    }


    private E pollFirst() {
        if (head == null) {
            throw new NullPointerException("no element in this queue");
        }
        Node temp = head;
        head = head.next;
        size--;
        return (E) temp.get();
    }

    public E get(int index) {
        return null;
    }

    private static class Node<E> {
        Node prev;
        Node next;
        E e;

        public Node(E e) {
            this.e = e;
        }

        public E get() {
            return e;
        }
    }
}
