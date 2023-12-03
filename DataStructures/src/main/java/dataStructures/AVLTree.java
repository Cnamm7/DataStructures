package dataStructures;

import dataStructuresImpl.AVLTreeImpl;

/**
 * implementing the AVLTree from scratch with different methods
 *
 * An AVL tree defined as a self-balancing Binary Search Tree (BST) where the difference between
 * heights of left and right subtrees for any node cannot be more than one.
 */

public interface AVLTree {

    void insert(int value);
    boolean delete(int value);
    boolean search(int value);
}
