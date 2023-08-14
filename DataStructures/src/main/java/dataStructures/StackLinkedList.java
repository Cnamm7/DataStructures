package dataStructures;

import customException.DataStructuresExeption;
import dataStructuresImpl.StackLinkedListImpl;

public interface StackLinkedList {
    public StackLinkedListImpl.StackNode push(int value);
    public StackLinkedListImpl.StackNode pop() throws DataStructuresExeption;
    public int getLength();
    public void print();
    public void getTop();
    public void printHeight();
}
