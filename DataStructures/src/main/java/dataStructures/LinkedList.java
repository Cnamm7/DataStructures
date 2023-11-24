package dataStructures;

import customException.DataStructuresExeption;
import dataStructuresImpl.LinkedListImpl;

import java.util.List;
/**
 * implementing the LinkedList data structure with different methods
 */
public interface LinkedList {
    /**
     * append the value at the end
     * @param value
     */
    public void append(int value);

    /**
     * remove the last element
     * @return the node that removed
     * @throws DataStructuresExeption
     */
    public LinkedListImpl.Node removeLast() throws DataStructuresExeption;

    /**
     * remove the first element
     * @return the node taht removed
     * @throws DataStructuresExeption
     */
    public LinkedListImpl.Node removeFirst() throws DataStructuresExeption;

    /**
     * remove the specific node with input index
     * @param index
     * @return the node that removed
     * @throws DataStructuresExeption
     */
    public LinkedListImpl.Node remove(int index) throws DataStructuresExeption;

    /**
     * append the value to the first of the list
     * @param value
     */
    public void prepend(int value);

    /**
     * insert a value in the given index
     * @param index
     * @param value
     * @return true if insert was successful, false otherwise
     * @throws DataStructuresExeption
     */
    public boolean insert(int index, int value) throws DataStructuresExeption;

    /**
     * insert a array of values at specified index
     * @param index
     * @param values
     * @return true if insert was successful, false otherwise
     */
    public boolean insert(int index, int[] values);

    /**
     * insert a list of values at specified index
     * @param index
     * @param values
     * @return true if insert was successful, false otherwise
     */
    public boolean insert(int index, List<Integer> values);

    /**
     * return the size of the linkedList
     * @return
     */
    public int size();

    /**
     * print the list
     */
    public void printList();

    /**
     * print the head of linkedList
     */
    public void getHead();

    /**
     * get specified node at the input index
     * @param index
     * @return the requested node
     * @throws DataStructuresExeption
     */
    public LinkedListImpl.Node get(int index) throws DataStructuresExeption;

    /**
     * print the tail of the list
     */
    public void getTail();

    /**
     * print the length of the list
     */
    public void getLength();

    /**
     * set the value at given index
     * @param index
     * @param value
     * @return
     * @throws DataStructuresExeption
     */
    public boolean set(int index, int value) throws DataStructuresExeption;

    /**
     * print the whole list
     */
    public void print();

    /**
     * reverse the linkedList
     */
    public void reverse();

    /**
     * find the node in the middle of the list
     * @return the middle node
     */
    public LinkedListImpl.Node findMiddleNode();

    /**
     * check whether the LinkedList has loop and it won't end(training purposes for finding loop bug)
     * @return true if it has loop, false otherwise
     */
    public boolean hasLoop();

    /**
     * find the kth element from the start
     * @param k
     * @return kth element from start
     */
    public LinkedListImpl.Node findKthFromStart(int k);

    /**
     * find the kth element from the end
     * @param k
     * @return kth element from end
     */
    public LinkedListImpl.Node findKthFromEnd(int k);



    /**
     * reverse between two indexes
     * @param k
     * @param j
     */
    public void reverseBetween(int k, int j);
}
