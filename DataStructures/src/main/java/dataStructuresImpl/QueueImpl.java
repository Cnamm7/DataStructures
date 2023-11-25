package dataStructuresImpl;

import customException.DataStructuresExeption;
import dataStructures.Queue;

/**
 * implementation of Queue Interface, explanation of general functions provided on the interface level
 */
public class QueueImpl implements Queue {
    // pointer to the first node
    QueueNode first;
    // pointer to the last node
    QueueNode last;
    // length of queue
    int length = 0;

    /**
     * constructor of the queue, setting both first and last elements to the new node with value entered
     * @param value
     */
    public QueueImpl(int value) {
        QueueNode node = new QueueNode(value);
        this.last = node;
        this.first = node;
        this.length++;
    }

    @Override
    public void enqueue(int value) {
        // creating a new node with the value
        QueueNode node = new QueueNode(value);
        // and set the next pointer of the last node to the new value
        this.last.next = node;
        // and move the last pointer to the new last element
        this.last = node;
        this.length++;
    }

    @Override
    public QueueNode dequeue() throws DataStructuresExeption {
        // if the length is 0 will throw exception
        if (this.length == 0) {
            throw new DataStructuresExeption("the length is 0");
        }
        // set a pointer to the first element
        QueueNode node = this.first;
        // move the first pointer to the next element in the list
        this.first = this.first.next;
        // remove the original first pointer to null in order for garbage collection removal
        node.next = null;
        this.length--;
        return node;
    }

    @Override
    public void printLength() {
        System.out.println("Length: " + this.length);
    }

    @Override
    public void printQueue() {
        // start iterating from the first and print all elements of the list
        QueueNode node  = this.first;
        while (node != null) {
            System.out.print(node.value + "-> ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public void printFirstAndLast() {
        // simply print first and last elements
        System.out.println("first:" + this.first.value);
        System.out.println("last:" + this.last.value);
    }

    /**
     * implementation of the node of the class, having a value and a pointer to the next
     */
    public class QueueNode {
        int value;
        QueueNode next;

        public QueueNode(int value) {
            this.value = value;
        }
    }
}
