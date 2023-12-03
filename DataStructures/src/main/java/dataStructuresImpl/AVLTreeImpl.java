package dataStructuresImpl;

import dataStructures.AVLTree;

import static java.lang.Math.max;

public class AVLTreeImpl implements AVLTree {
    AVLTreeNode root;

    public AVLTreeImpl(int value) {
        root = new AVLTreeNode(value);
    }
    /**
     * @param value
     * @return
     */
    @Override
    public void insert(int value) {
        insert(root, value);
        updateHeight();
    }

    private void updateHeight() {
        class Traverse {
            Traverse (AVLTreeNode node) {
                new Traverse(node.left);
                new Traverse(node.right);
                node.height = max(getHight(node.left), getHight(node.right)) + 1;
            }
        }

        new Traverse(root);
    }

    private int getHight(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }

        return getHight(node.left) - getHight(node.right);
    }

    private AVLTreeNode rightRotate(AVLTreeNode node) {
        AVLTreeNode left = node.left;
        AVLTreeNode leftRight = left.right;

        left.right = node;
        node.left = leftRight;

        node.height = max(getHight(node.left), getHight(node.right)) + 1;
        left.height = max(getHight(left.left), getHight(left.right)) + 1;

        return left;
    }

    private AVLTreeNode leftRotate(AVLTreeNode node) {
        AVLTreeNode right = node.right;
        AVLTreeNode rightLeft = right.left;

        right.left = node;
        node.right = rightLeft;

        node.height = max(getHight(node.left), getHight(node.right)) + 1;
        right.height = max(getHight(right.left), getHight(right.right)) + 1;

        return right;
    }


    public AVLTreeNode insert(AVLTreeNode node, int value) {
        if (node == null) {
            return new AVLTreeNode(value);
        }

        if (node.value > value) {
            node.right = insert(node.right, value);
        } else if (node.value < value) {
            node.left = insert(node.left, value);
        } else {
            return node;
        }

        return node;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean delete(int value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean search(int value) {
        return false;
    }


    public class AVLTreeNode {
        int value;
        int height;
        AVLTreeNode left;
        AVLTreeNode right;

        public AVLTreeNode(int value) {
            this.value = value;
            height = 1;
        }
    }
}


