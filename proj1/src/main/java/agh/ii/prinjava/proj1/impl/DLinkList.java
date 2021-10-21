package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        private Node(T elem, Node<T> next, Node<T> prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> firstNode;
    private Node<E> lastNode;

    /**
     * This method returns the element of the first node of the double linked list.
     * @return element of the first node
     */
    public E getFirstNode(){
        return firstNode.elem;
    }

    /**
     * This method returns the element of the last node of the double linked list.
     * @return element of the last node
     */
    public E getLastNode(){
        return lastNode.elem;
    }

    /**
     * This method adds a new element at the beginning of the double linked list.
     * @param e the new element
     */
    public void addFirst(E e){
        if (firstNode == null){
            firstNode = new Node<>(e, null, null);
            lastNode = firstNode;
        }
        else{
           Node<E> n = new Node<>(e, firstNode, null);
           firstNode.prev = n;
           firstNode = n;
        }
    }

    /**
     * This method adds an element at the end of a double linked list.
     * @param e the new element
     */
    public void addLast(E e){
        if (firstNode == null){
            firstNode = new Node<>(e, null, null);
            lastNode = firstNode;
        }
        else{
            Node<E> n = new Node<>(e, null, lastNode);
            lastNode.next = n;
            lastNode = n;
        }
    }

    /**
     * This method removes and returns the first element of the double linked list.
     * @return first element
     */
    public E removeFirst(){
        if(firstNode == null){
            return null;
        }
        else if(firstNode.next != null){
            E elem = firstNode.elem;
            firstNode.next.prev = null;
            firstNode = firstNode.next;
            return elem;
        }
        else{
            E elem = firstNode.elem;
            firstNode = null;
            return elem;
        }
    }

    /**
     * This method removes and returns the last element of the double linked list.
     * @return last element
     */
    public E removeLast(){
        if(firstNode == null){
            return null;
        }
        else if(firstNode.next == null){
            E elem = firstNode.elem;
            firstNode = null;
            lastNode = null;
            return elem;
        }
        else{
            E elem = lastNode.elem;
            lastNode.prev.next = null;
            lastNode = lastNode.prev;
            return elem;
        }
    }

    /**
     * This method returns the length of the double linked list
     * @return length
     */
    public int getLength(){
        if (firstNode == null){
            return 0;
        }
        else{
            Node<E> copy = firstNode;
            int counter = 1;
            while(copy.next != null){
                copy = copy.next;
                counter++;
            }
            return counter;
        }
    }

    /**
     * This method prints the double linked list
     * @return the string of the double linked list
     */
    @Override
    public String toString(){
        Node<E> copy = firstNode;
        String s = "";
        while (copy != null){
            s += copy.elem + " ";
            copy = copy.next;
        }
        return (s);
    }
}
