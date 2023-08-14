package dataStructures;

import java.util.List;

public interface Heap {
    public void insert(int value);
    public Integer remove();
    public List<Integer> getHeap();
    public void printHeap();
}
