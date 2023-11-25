package dataStructures;

import customException.DataStructuresExeption;
import dataStructuresImpl.QueueImpl;
/**
 * implementing the Queue data structure with different methods
 */
public interface Queue {
    /**
     * inserting a value in queue
     * @param value
     */
    public void enqueue(int value);

    /**
     * removing a node from queue
     * @return the remove node
     * @throws DataStructuresExeption
     */
    public QueueImpl.QueueNode dequeue() throws DataStructuresExeption;

    /**
     * print the length of queue
     */
    public void printLength();

    /**
     * print the queue
     */
    public void printQueue();

    /**
     * print first and lest element of queue
     */
    public void printFirstAndLast();
}
