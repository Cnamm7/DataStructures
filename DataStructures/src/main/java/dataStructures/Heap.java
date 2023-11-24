package dataStructures;

import java.util.List;
/**
 * implementing the Heap data structures with different methods
 */
public interface Heap {
    /**
     * insert this value to the heap
     * @param value
     */
    public void insert(int value);

    /**
     * remove the root and top value of heap
     */
    public Integer remove();

    /**
     * return the current stage and list of heap
     * @return
     */
    public List<Integer> getHeap();

    /**
     * print the current heap
     */
    public void printHeap();
}
