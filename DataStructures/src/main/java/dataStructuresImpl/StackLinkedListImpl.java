package dataStructuresImpl;

import customException.DataStructuresExeption;
import dataStructures.StackLinkedList;


public class StackLinkedListImpl implements StackLinkedList {
    StackNode top;
    int length;

    public StackLinkedListImpl(int value) {
        StackNode node = new StackNode(value);
        this.top = node;
        length = 1;
    }

    @Override
    public StackNode push(int value) {
        StackNode node = new StackNode(value);
        if (this.length == 0) {
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }
        length++;
        return node;
    }

    @Override
    public StackNode pop() throws DataStructuresExeption {
        if (length == 0) {
            throw new DataStructuresExeption("the stack is empty");
        } else {
            StackNode temp = this.top;
            this.top = this.top.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public void print() {
        StackNode temp = this.top;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    @Override
    public void getTop() {
        System.out.println("Top: " + this.top.value);
    }

    @Override
    public void printHeight() {
        System.out.println("Length: " + this.length);
    }

    public class StackNode {
        int value;
        StackNode next;

        public StackNode(int value) {
            this.value = value;
        }
    }
}
