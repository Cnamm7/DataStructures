package dataStructures;

import customException.DataStructuresExeption;
import dataStructuresImpl.LinkedListImpl;

import java.util.List;

public interface LinkedList {
    public void append(int value);
    public LinkedListImpl.Node removeLast() throws DataStructuresExeption;
    public LinkedListImpl.Node removeFirst() throws DataStructuresExeption;
    public LinkedListImpl.Node remove(int index) throws DataStructuresExeption;
    public void prepend(int value);
    public boolean insert(int index, int value) throws DataStructuresExeption;
    public boolean insert(int index, int[] values);
    public boolean insert(int index, List<Integer> values);
    public int size();
    public void printList();
    public void getHead();
    public LinkedListImpl.Node get(int index) throws DataStructuresExeption;
    public void getTail();
    public void getLength();
    public boolean set(int index, int value) throws DataStructuresExeption;
    public void print();
    public void reverse();
    public LinkedListImpl.Node findMiddleNode();
    public boolean hasLoop();
    public LinkedListImpl.Node findKthFromEnd(int k);
    public void reverseBetween(int k, int j);
}
