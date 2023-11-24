package dataStructures;


import dataStructuresImpl.BinarySearchTreeImpl;

import java.util.List;
/*
implementing the BinarySearchTree from scratch with different methods
 */
public interface BinarySearchTree {
    /**
     * Insert a value in the tree with normal method without using recursive
     * @param value
     */
    void insert(int value);

    /**
     * Removing a value from Binary Search Tree with normal method without using recursive
     * @param value
     * @return boolean based on whether it was successful or not
     */
    boolean remove(int value);

    /**
     * Check whether a value is in Binary Search Tree or not
     * @param value
     * @return boolean
     */
    boolean lookup(int value);

    /**
     * Return the current root of Binary Search Tree
     * @return root node
     */
    BinarySearchTreeImpl.BinaryTreeNode getRoot();

    /**
     * Using recursive method for lookUp
     * @param value
     * @return boolean whether it was successful finding it or not
     */
    boolean rLookup(int value);

    /**
     * Using recursive method for removing an element
     * @param value
     */
    void rRemove(int value);

    /**
     * Using recursive method for inserting an element
     * @param value
     */
    void rInsert(int value);

    /**
     * Check the current size
     * @return integer showing the current size
     */
    int size();

    /**
     * Breadth First Search Method for this Binary Search Tree, visiting and printing nodes level by level
     * @return List of integers based on the search method
     */
    List<Integer> BFS();

    /**
     * Depth First Search(preorder: parent, left, right) Method for this Binary Search Tree
     * @return List of integer based on the search method
     */
    List<Integer> DFSPreOrder();

    /**
     * Depth First Search(postorder: left, right, parent) Method for this Binary Search Tree
     * @return List of integer based on the search method
     */
    List<Integer> DFSPostOrder();

    /**
     * Depth First Search(inorder: left, parent, right) Method for this Binary Search Tree
     * @return List of integer based on the search method
     */
    List<Integer> DFSInOrder();
}
