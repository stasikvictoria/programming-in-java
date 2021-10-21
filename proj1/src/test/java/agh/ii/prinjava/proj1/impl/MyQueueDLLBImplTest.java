package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp() {
        System.out.println("The test begins");
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("The test ends");
    }

    /**
     * We add a 4 at the end of the queue, and we verify that the last element is 4.
     */
    @Test
    void testEnqueue(){
        queueOfInts.enqueue(4);
        assertEquals(4, queueOfInts.getLastElement());
    }

    /**
     * We dequeue the queue and we verify that the value returned is 1 (the first element of the queue).
     */
    @Test
    void testDequeue(){
        assertEquals(1,queueOfInts.dequeue());
    }

    /**
     * We verify that the number of elements is equal to 3.
     */
    @Test
    void testNumOfElems(){
        assertEquals(3,queueOfInts.numOfElems());
    }

    /**
     * We peek the first value of the queue, and we verify that it is equal to 1.
     */
    @Test
    void testPeek(){
        assertEquals(1, queueOfInts.peek());
    }
}