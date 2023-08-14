package dataStructuresImpl;

import customException.DataStructuresExeption;
import dataStructures.LinkedList;

import java.util.List;

public class LinkedListImpl implements LinkedList {

    private int length;
    private Node head;
    private Node tail;

    public LinkedListImpl(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public LinkedListImpl(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public LinkedListImpl(int[] array){
        this(array[0]);
        for (int i = 1; i < array.length; i++) {
            this.append(array[i]);
        }
    }

    public LinkedListImpl(List<Integer> list){
        this(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            this.append(list.get(i));
        }
    }

    @Override
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    @Override
    public Node removeLast() throws DataStructuresExeption {
        Node returnNode;
        if (length == 0) {
            throw new DataStructuresExeption("The list is empty");
        } else if (length == 1) {
            returnNode = this.head;
            this.head = null;
            this.tail = null;
        } else {
            Node node = this.head;
            returnNode = this.tail;
            for (int i = 1; i < this.length - 1; i++) {
                node = node.next;
            }
            this.tail = node;
            node.next = null;
        }
        this.length--;
        return returnNode;
    }

    public LinkedListImpl.Node removeFirst() throws DataStructuresExeption {
        Node ReturnNode;
        if (length == 0) {
            throw new DataStructuresExeption("The list is empty");
        } else if (length == 1) {
            ReturnNode = this.head;
        } else {
            Node node = this.head;
            this.head = this.head.next;
            ReturnNode = node;
            node.next = null;
        }
        this.length--;
        return ReturnNode;
    }

    @Override
    public LinkedListImpl.Node remove(int index) throws DataStructuresExeption {
        if (index == 0) {
            return this.removeFirst();
        } else if (index == length - 1) {
            return this.removeLast();
        } else if (index < 0 || index >= length) {
            throw new DataStructuresExeption("index out of bound");
        } else {
            Node preNode = this.get(index - 1);
            Node currentNode = this.get(index);
            preNode.next = currentNode.next;
            currentNode.next = null;
            this.length--;
            return currentNode;
        }
    }

    @Override
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    @Override
    public boolean insert(int index, int value) throws DataStructuresExeption {
        if (index < 0 && index > this.length) {
            return false;
        } else if (index == this.length) {
            this.append(value);
            return true;
        } else if (index == 0) {
            this.prepend(value);
            return true;
        } else {
            Node node = this.get(index - 1);
            Node newNode = new Node(value);
            newNode.next = node.next;
            node.next = newNode;
            this.length++;
            return true;
        }
    }

    @Override
    public boolean insert(int index, int[] values){
        if (index < 0 && index > this.length) {
            return false;
        } else if (index == this.length) {
            for (int i = 0; i < values.length; i++) {
                this.append(values[i]);
            }
            return true;
        } else if (index == 0) {
            for (int i = 0; i < values.length; i++) {
                this.prepend(values[i]);
            }
            return true;
        } else {
            int current = 1;
            Node node = this.head;
            while (node.next != null){
                node = node.next;
                current++;
                if (current == index) {break;}
            }
            for (int i = values.length -1; i > -1 ; i--) {
                Node newNode = new Node(values[i]);
                newNode.next = node.next;
                node.next = newNode;
                this.length++;
            }
            return true;
        }
    }

    @Override
    public boolean insert(int index, List<Integer> values){
        if (index < 0 && index > this.length) {
            return false;
        } else if (index == this.length) {
            for (int i = 0; i < values.size(); i++) {
                this.append(values.get(i));
            }
            return true;
        } else if (index == 0) {
            for (int i = 0; i < values.size(); i++) {
                this.prepend(values.get(i));
            }
            return true;
        } else {
            int current = 1;
            Node node = this.head;
            while (node.next != null){
                node = node.next;
                current++;
                if (current == index) {break;}
            }
            for (int i = values.size() -1; i > -1 ; i--) {
                Node newNode = new Node(values.get(i));
                newNode.next = node.next;
                node.next = newNode;
                this.length++;
            }
            return true;
        }
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    @Override
    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    @Override
    public Node get(int index) throws DataStructuresExeption{
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return this.head;
        } else if (index < 0 || index >= length) {
            throw new DataStructuresExeption("The index can't be negative or out of bound");
        } else {
            Node temp = this.head;
            int counter = 0;
            while (counter < index) {
                temp = temp.next;
                counter++;
            }
            return temp;
        }
    }

    @Override
    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    @Override
    public void getLength() {
        System.out.println("Length: " + length);
    }

    @Override
    public boolean set(int index, int value) throws DataStructuresExeption {
        Node node = new Node(value);
        if (length == 0) {
            return false;
        } else if (index < 0 || index >= length) {
            throw new DataStructuresExeption("The index can't be negative or out of bound");
        } else {
            this.get(index).value = value;
        }
        return true;
    }

    @Override
    public void print() {
        if (length == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.print("[");
            Node node = this.head;
            System.out.print(node.value);
            while (node.next != null) {
                node = node.next;
                System.out.print(" ," + node.value);
            }
            System.out.println("]");
        }
    }

    @Override
    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        Node after;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    @Override
    public Node findMiddleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (true) {
            if (fast == null) {
                break;
            } else if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Override
    public boolean hasLoop() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LinkedListImpl.Node findKthFromEnd(int k) {
        Node fast = this.head;
        Node slow = this.head;
        return fast;
    }

    @Override
    public void reverseBetween(int k, int j) {
        Node fast = this.head;
        Node slow = this.head;

        for (int i = 0; i < k -1; i++) {
            slow = slow.next;
        }
        for (int i = 0; i < j; i++) {
            fast = fast.next;
        }
    }


    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}