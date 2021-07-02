package com.wink.learn.jianzhioffer;

/**
 * description: Node <br>
 * date: 2021/3/22 上午11:50 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Node<V>{

    private V value;

    private Node<V> next;

    public Node(){

    }

    public Node(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }
}
