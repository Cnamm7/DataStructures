package dataStructures;

import customException.DataStructuresExeption;
import dataStructuresImpl.QueueImpl;

public interface Queue {
    public void enqueue(int value);
    public QueueImpl.QueueNode dequeue() throws DataStructuresExeption;
    public void printLength();
    public void printQueue();
    public void printFirstAndList();
}
