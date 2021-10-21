package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
        System.out.println("The test begins");
        stackOfInts.push(3);
        stackOfInts.push(2);
        stackOfInts.push(1);
    }

    @AfterEach
    void tearDown() {
        System.out.println("The test ends");
    }

    /**
     * We pop the first element of the stack and we verify if it's equal to 1.
     */
    @Test
    void testPop(){
        assertEquals(stackOfInts.pop(), 1);
    }

    /**
     * We puch the element 0 at the beginning of the stack.
     * We verify if the first element of the stack is equal to 0.
     */
    @Test
    void testPush(){
        stackOfInts.push(0);
        assertEquals(0,stackOfInts.getFirstElement());
    }

    /**
     * We verify if the number of elements of the stack is equal to 3.
     */
    @Test
    void testNumOfElems(){
        assertEquals(3,stackOfInts.numOfElems());
    }

    /**
     * We peek the first element of the stack, and we verify that it's equal to 1.
     */
    @Test
    void testPeek(){
        assertEquals(1, stackOfInts.peek());
    }
}