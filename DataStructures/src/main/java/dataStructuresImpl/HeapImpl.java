package dataStructuresImpl;

import dataStructures.Heap;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl implements Heap {
    List<Integer> heap;

    public HeapImpl(){
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(int value) {
        this.heap.add(value);
        int current = this.heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(this.parent(current))) {
            swap(current, this.parent(current));
            current = parent(current);
        }
    }



    @Override
    public Integer remove() {
        if (this.heap.size() == 0) {
            return null;
        }

        if (this.heap.size() == 1) {
            this.heap.remove(0);
        }

        int returnValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        sinkDown(0);

        return returnValue;

    }

    @Override
    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    @Override
    public void printHeap() {
        System.out.println(this.heap);
    }

    private void sinkDown(int index) {
        int current = index;
        while (true) {
            int left = this.leftChild(index);
            int right = this.rightChild(index);

            if (left < this.heap.size() && this.heap.get(current) < this.heap.get(left)) {
                current = left;
            }

            if (right < this.heap.size() && this.heap.get(current) < this.heap.get(right)) {
                current = right;
            }

            if(current != index) {
                swap(current, index);
                index = current;
            } else {
                break;
            }
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
