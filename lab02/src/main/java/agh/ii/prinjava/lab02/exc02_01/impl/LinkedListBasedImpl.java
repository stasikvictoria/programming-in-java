package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {
    private Node first;

    public LinkedListBasedImpl() {}

    @Override
    public int pop() {
        if (first != null) {
            Node last = first;
            Node previous = first;

            if (first.next == null) this.first = null;

            while (last.next != null) {
                previous = last;
                last = last.next;
            }

            previous.next = null;

            return last.elem;
        }
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public void push(int x) {
        if (first == null) {
            first = new Node(x);
        }

        else {
            Node last = first;

            while (last.next != null) {
                last = last.next;
            }

            last.next = new Node(x);
        }
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public int numOfElems() {
        int num = 0;
        for (Node n = first; n != null; n = n.next) num++;
        int numOfElems = num+1;
        return numOfElems;
    }

    @Override
    public int peek() {
        if (first != null) {
            Node temp = first;
            first = first.next;

            return temp.elem;
        }
        throw new IllegalStateException("To be implemented");
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem) {
            this.elem = elem;
        }
    }

    private int numOfElems = 0;
}
