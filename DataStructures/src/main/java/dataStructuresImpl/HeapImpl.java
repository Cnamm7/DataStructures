package dataStructuresImpl;

import dataStructures.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * implementation of Heap Interface with MaxHeap Strategy(putting the max value in root), explanation of general functions provided on the interface level
 */
public class HeapImpl implements Heap {
    // create the list of heap
    List<Integer> heap;
    // construct the heap object
    public HeapImpl(){
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(int value) {
        // first add the value at the end of the list
        this.heap.add(value);
        // get the index of the value we just added
        int current = this.heap.size() - 1;

        // check whether current is in the right place, if it is more than the parent then swap it with parent
        while (current > 0 && heap.get(current) > heap.get(this.parent(current))) {
            swap(current, this.parent(current));
            current = parent(current);
        }
    }



    @Override
    public Integer remove() {
        // check whether the list is empty
        if (this.heap.size() == 0) {
            return null;
        }
        // if the size is one so we have one element and we just remove that one
        if (this.heap.size() == 1) {
            this.heap.remove(0);
        }
        // in remove function we need to remove the root or head of the list which is the max value, so we put the last value in the list
        // in the root and then sink the value down for rearranging the values in heap
        int returnValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        sinkDown(0);

        return returnValue;

    }
    /*
    returning the deep copy of the heap
     */
    @Override
    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    @Override
    public void printHeap() {
        System.out.println(this.heap);
    }

    /**
     * sinkDown method is used for rearranging the heap by placing the values in right order from top to bottom
     * @param index
     */
    private void sinkDown(int index) {
        // setting the current value to the index
        int current = index;
        // creating a while loop for rearranging
        while (true) {
            // getting both left and right child's indexes
            int left = this.leftChild(index);
            int right = this.rightChild(index);
            // if the left index still in the range of the list and current is less than the left, put current pointer to the left
            if (left < this.heap.size() && this.heap.get(current) < this.heap.get(left)) {
                current = left;
            }
            // if the right index still in the range of the list and current is less than the right, put current pointer to the right
            if (right < this.heap.size() && this.heap.get(current) < this.heap.get(right)) {
                current = right;
            }
            // if the current changed and is equal to left or right then swap it, until it is in the right place
            if(current != index) {
                swap(current, index);
                index = current;
            } else {
                break;
            }
        }
    }

    /**
     * helper function to get left child in the heap, by assuming the heap is starts from index 0
     * @param index
     * @return the left child index
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * helper function to get right child in the heap, by assuming the heap is starts from index 0
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * helper function to get parent, by considering integer division, if its odd then the value will be floored
     * and we allways get the parent index of the current index
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * helper function to swap two indexes
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
