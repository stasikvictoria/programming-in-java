package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * This method returns the last element of the queue.
     * @return last element
     */
    public E getLastElement(){
        return elems.getLastNode();
    }

    /**
     * The enqueue function will add an element at the end of the queue.
     * @param x element of the last node
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * The dequeue function will remove and return the first element of the queue.
     * @return first element
     */
    @Override
    public E dequeue() {
        return elems.removeFirst();
    }

    /**
     * The function numOfElems will give us the number of elements in the queue.
     * @return counter - number of elements
     */
    @Override
    public int numOfElems() {
        return elems.getLength();
    }

    /**
     * The function peek is used to return the first element of the queue without removing it.
     * @return first element or null if it is empty
     */
    @Override
    public E peek() {
        return elems.getFirstNode();
    }
}
