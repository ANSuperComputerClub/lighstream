package com.ansupercomputer.lightstream.UtilTests;

import com.ansupercomputer.lightstream.Util.CircularQueue;
import com.ansupercomputer.lightstream.Util.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CircularQueueTests {

    Logger logger = new Logger("CircularQueueTest");

    @Test
    void testAdd() {
        CircularQueue<String> queue = new CircularQueue<>();

        // Test adding elements to the queue
        assertTrue(queue.add("first"));
        assertTrue(queue.add("second"));
        assertTrue(queue.add("third"));

        // Test that the oldest element is replaced when the queue is full
        for (int i = 0; i < 100; i++) {
            assertTrue(queue.add("new element"));
        }

        assertEquals("new element", queue.get(0));
        assertEquals("new element", queue.get(99));
    }
}