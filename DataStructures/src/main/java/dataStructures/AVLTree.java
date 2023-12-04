package dataStructures;

/**
 * implementing the AVLTree from scratch with different methods
 *
 * An AVL tree defined as a self-balancing Binary Search Tree (BST) where the difference between
 * heights of left and right subtrees for any node cannot be more than one.
 */

public interface AVLTree {

    /**
     * inserting a value in the tree and self balance the tree until it become balanced based on AVLTree standard
     * @param value the value we want to insert in the tree
     */
    void insert(int value);

    /**
     * delete the value from tree and self balance the tree until it become balanced based on AVLTree standard
     * @param value the value we want to remove from the tree
     */
    void delete(int value);

    /**
     * recursive look up for the value we insert in the tree
     * @param value
     * @return true if the value exist, false otherwise
     */
    boolean search(int value);
}
