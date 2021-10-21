package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * This method returns the first element of the stack.
     * @return first element
     */
    public E getFirstElement(){return elems.getFirstNode();}

    /**
     * This method removes and returns the first element of the stack.
     * @return first element
     */
    @Override
    public E pop() {return elems.removeFirst();}

    /**
     * This method adds an element at the first place in the stack.
     * @param x element to add at the beginning
     */
    @Override
    public void push(E x) {elems.addFirst(x);}

    /**
     * This method gives us the number of elements in the stack.
     * @return number of elements
     */
    @Override
    public int numOfElems() {return elems.getLength();}

    /**
     * This method returns the first element of the stack without remove it.
     * @return first element of the stack
     */
    @Override
    public E peek() {return elems.getFirstNode();}
}
