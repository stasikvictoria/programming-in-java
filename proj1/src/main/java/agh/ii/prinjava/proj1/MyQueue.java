package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

public interface MyQueue<E> {
    /**
     * This method returns the last node of the queue.
     * @return the last node
     */
    E getLastElement();

    /**
     * This method add an element at the end of the queue.
     * @param x the element of the last node
     */
    void enqueue(E x);

    /**
     * This method remove and return the first node of the queue.
     * @return the first node
     */
    E dequeue();

    /**
     * This method returns a boolean to know if the list is empty or not.
     * @return true (is empty) or false (is not empty)
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * This method give us the number of nodes in the queue.
     * @return the number of nodes
     */
    int numOfElems();

    /**
     * This method return the first element of the queue without removing it.
     * @return the first node
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
