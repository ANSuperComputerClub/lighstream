package com.ansupercomputer.lightstream.Util;

import java.util.*;
/**
 * A data structure that defines a circular queue.
 * Importantly, when the structure is full, the oldest element is replaced.
 * This allows the Queue to store the most recent data without the older data.
 */
public class CircularQueue<T> extends ArrayList<T> {

    private static final int CAPACITY = 100;
    private int head = 0; // index of the oldest element
    private int tail = 0; // index where the next element will be added

    /**
     * Constructs a new circular queue with a capacity of 100.
     */
    public CircularQueue() {
        super(CAPACITY);
    }

    /**
     * Adds an element to the end of the queue. If the queue is full, the oldest
     * element is replaced to make space for the new element.
     * @param element the element to add to the queue
     * @return true if successful, false if not
     */
    public boolean add(T element) {
        if (size() < CAPACITY) {
            super.add(tail++, element);
        } else {
            // replace the oldest element with the new element
            super.set(head++, element);
            if (head == CAPACITY) {
                head = 0;
            }
            if (tail == CAPACITY) {
                tail = 0;
            }
        }
        return true;
    }
}
