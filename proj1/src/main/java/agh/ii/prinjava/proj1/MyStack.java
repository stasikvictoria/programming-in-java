package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

public interface MyStack<E> {
    /**
     * This method returns the last node of the stack (the one at the bottom).
     * @return last node of the stack
     */
    E getFirstElement();

    /**
     * This method is used to remove and return the last element of the stack (the one at the top).
     * @return the last node
     */
    E pop();

    /**
     * This method add an element at the top of the stack.
     * @param x element of the new Node
     */
    void push(E x);

    /**
     * This method returns a boolean to know if the list is empty or not.
     * @return true (is empty) or false (is not empty)
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * This method give us the number of nodes in the stack.
     * @return number of nodes
     */
    int numOfElems();

    /**
     * This method returns the first element of the stack without removing it.
     * @return the first element od the stack
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
