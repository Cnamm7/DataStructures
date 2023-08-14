package dataStructures;


import dataStructuresImpl.BinarySearchTreeImpl;

public interface BinarySearchTree {
    public void insert(int value);
    public boolean remove(int value);
    public boolean lookup(int value);
    public BinarySearchTreeImpl.BinaryTreeNode getRoot();
    public boolean rLookup(int value);
    public void rRemove(int value);
    public void rInsert(int value);
    public int size();
    public void print();
}
