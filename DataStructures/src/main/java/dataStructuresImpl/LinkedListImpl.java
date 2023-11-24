package dataStructuresImpl;

import customException.DataStructuresExeption;
import dataStructures.LinkedList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * implementation of LinkedList Interface, explanation of general functions provided on the interface level
 */
public class LinkedListImpl implements LinkedList {
    // length of the list
    private int length;
    // pointer to the head of the list
    private Node head;
    // pointer to the tail of the list
    private Node tail;
    /*
     initializing the list by setting both head and tail to null and length to 0
     */
    public LinkedListImpl(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    /*
     initializing the list with a value for the first node
     */
    public LinkedListImpl(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    /*
    initializing the list with an array
     */
    public LinkedListImpl(int[] array){
        this(array[0]);
        for (int i = 1; i < array.length; i++) {
            this.append(array[i]);
        }
    }
    /*
    initializing the list with a List
     */
    public LinkedListImpl(List<Integer> list){
        this(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            this.append(list.get(i));
        }
    }

    @Override
    public void append(int value) {
        // create a new node with the given value
        Node newNode = new Node(value);
        // if the list is empty then set bot head and tail to the node, else append it to the tail next and move
        // the tail pointer onto it
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
        // create a pointer
        Node returnNode;
        // if the list is empty it will throw an exception, else if the size is one it simply removes the only node and set
        // both head and tail to null, else it itterate through the list until the one before tail and remove tail and relocate
        // tail pointer
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
        // create a pointer
        Node ReturnNode;
        // if the list is empty throw an exception, else if the length is one set the head to null and return the node,
        // else move the head pointer to next and remove the first one
        if (length == 0) {
            throw new DataStructuresExeption("The list is empty");
        } else if (length == 1) {
            ReturnNode = this.head;
            this.head = null;
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
        // if the index is 0 simply remove first, else if its equal to the last index remove the last, else simply
        // remove the node by using get methods on previous node and current node
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
        // create a new node to prepend to list, if the length is 0 just point head and tail to it, else point the head to new node
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
        // if index is out of bound return false, else if it's at the end or first of the list, simply using append and prepend
        // methods, else get the previous node and create and the new node and put it in the list
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
        // if index is out of bound return false, else if it's at the end or first of the list, simply using append and prepend
        // methods, else get the node at index at insert the list before that node
        if (index < 0 && index > this.length) {
            return false;
        } else if (index == this.length) {
            for (int value : values) {
                this.append(value);
            }
            return true;
        } else if (index == 0) {
            for (int value : values) {
                this.prepend(value);
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
        // same insert method as array so we just create array from the list and pass it to insert method for array
        int[] arrayOfInputs = new int[values.size()];
        for (int i = 0; i < arrayOfInputs.length; i++) {
            arrayOfInputs[i] = values.get(i);
        }
        return insert(index, arrayOfInputs);
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public void printList() {
        // set the temp pointer to head and iterate through the list and print each value
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
        // if length is 0 return null, else if index equal to 1 return the first node which is head, and if index is out of bond
        // of indexes it will throw an exception, else it starts iterating to find the node that we are looking for.
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
        // simply see if length is 0 then return false, or if index is out of bound so it will throw an exception, else it will
        // use get method to set the new value.
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
        // check whether the length is 0, if it's not print the list by iterating through it
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
        // create 3 pointers, one at the current node, one to before the node and one to after and swap the head and tail
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        Node after;
        for (int i = 0; i < length; i++) {
            // first change the after to next
            after = temp.next;
            // set the next to before
            temp.next = before;
            // update the before to current node
            before = temp;
            // move the current pointer to next
            temp = after;
        }
    }

    @Override
    public Node findMiddleNode() {
        // use two pointer, one fast and one slow to iterate through the list, fast one go double the speed of slow one, so
        // when fast reaches the end of the list slow will be at the middle
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
        // check whether the list will end at some point by having again two pointer strategy which fast has double the slow
        // speed, and if at one point it didn't reach the end of linkedList and go back to start, it will return true
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
    public LinkedListImpl.Node findKthFromStart(int k) {
        // simply look for the kth element from the start by iterating until the given value
        if (k > length || k < 0) return null;
        Node temp = this.head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public LinkedListImpl.Node findKthFromEnd(int k) {
        // simply look for the kth element from the end by iterating until the given value minus the length
        if (k > length || k < 0) return null;
        Node temp = this.head;
        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public void reverseBetween(int k, int j) {
        // check if k is less than j or j and are out of bound here, if they are not then continue.
        if (k > j || j >= length || k <= 0) return;
        // creating 3 pointers, first is the first one in the list that should reverse and last is the last one
        // in the given threshold
        Node first = null;
        Node last = null;
        Node temp = this.head;

        for (int i = 0; i <= j; i++) {
            if (i == k) first = temp;
            if (i == j) last = temp;
            temp = temp.next;
        }

        // swap both first and last values here
        int value = last.value;
        last.value = first.value;
        first.value = value;

        // create a dummy to reverse based on that by iterating through the list and each time set the next to it,
        // and then move the dummy to current one
        Node dummy = last;
        temp = first.next;
        while (temp != last) {
            Node newNode = new Node(temp.value);
            newNode.next = dummy;
            dummy = newNode;
            temp = temp.next;
        }
        first.next = dummy;
    }


    /**
     * node class for this LinkedList, with the value of the node and pointer to the next node
     */
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