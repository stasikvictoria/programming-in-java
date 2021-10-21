package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    //List 1
    DLinkList<Integer> dLinkList = new DLinkList<>();
    //List 2
    DLinkList<Integer> nullDLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        System.out.println("The test begins");
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("The test ends");
    }

    /**
     * In the first list (1 2 3), we add at the beginning 0 and we check if the first element is 0.
     * In the second list (null), we add 0 and we check if the first element is 0.
     */
    @Test
    void testAddFirst(){
        dLinkList.addFirst(0);
        assertEquals(0, dLinkList.getFirstNode());

        nullDLinkList.addFirst(0);
        assertEquals(0, nullDLinkList.getFirstNode());
    }

    /**
     * In the first list (1 2 3) we add 4 at the end, and we check if the last node is 4.
     * In the second list (null) we add 0, and we check if the last node is 0.
     */
    @Test
    void testAddLast(){
        dLinkList.addLast(4);
        assertEquals(4, dLinkList.getLastNode());
        nullDLinkList.addFirst(0);
        assertEquals(0, nullDLinkList.getLastNode());
    }

    /**
     * We take the first list (1 2 3) and we remove its elements starting from the beginning.
     * The order of the removed elements must be 1 2 and 3.
     * We end the test with a null list.
     */
    @Test
    void testRemoveFirst(){
        Integer i = dLinkList.removeFirst();
        assertEquals(i, 1);

        i = dLinkList.removeFirst();
        assertEquals(i, 2);

        i = dLinkList.removeFirst();
        assertEquals(i, 3);

        i = dLinkList.removeFirst();
        assertNull(i);
    }

    /**
     * We take the first list (1 2 3) and we remove its elements starting from the end.
     * The order of the removed elements must be 3 2 1.
     * We end the test with a null list.
     */
    @Test
    void testRemoveLast(){
        Integer i = dLinkList.removeLast();
        assertEquals(i, 3);

        i = dLinkList.removeLast();
        assertEquals(i, 2);

        i = dLinkList.removeLast();
        assertEquals(i, 1);

        i = dLinkList.removeLast();
        assertNull(i);
    }

    /**
     * We check if the function returned a length of 3, as we put 3 values in the list.
     */
    @Test
    void testGetLength(){
        assertEquals(3, dLinkList.getLength());
    }

    /**
     * We verify if the string returned by the toString method is equal to 1 2 3.
     */
    @Test
    void testToString(){
        assertEquals(dLinkList.toString(), "1 2 3 ");
    }
}