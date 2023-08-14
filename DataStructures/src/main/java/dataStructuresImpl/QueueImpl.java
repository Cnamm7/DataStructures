package dataStructuresImpl;

import customException.DataStructuresExeption;
import dataStructures.Queue;

public class QueueImpl implements Queue {
    QueueNode first;
    QueueNode last;
    int length = 0;

    public QueueImpl(int value) {
        QueueNode node = new QueueNode(value);
        this.last = node;
        this.first = node;
        this.length++;
    }

    @Override
    public void enqueue(int value) {
        QueueNode node = new QueueNode(value);
        this.last.next = node;
        this.last = node;
        this.length++;
    }

    @Override
    public QueueNode dequeue() throws DataStructuresExeption {
        if (this.length == 0) {
            throw new DataStructuresExeption("the length is 0");
        }
        QueueNode node = this.first;
        this.first = this.first.next;
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
        QueueNode node  = this.first;
        while (node != null) {
            System.out.print(node.value + "-> ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public void printFirstAndList() {
        System.out.println("first:" + this.first.value);
        System.out.println("last:" + this.last.value);
    }

    public class QueueNode {
        int value;
        QueueNode next;

        public QueueNode(int value) {
            this.value = value;
        }
    }
}
