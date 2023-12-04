package dataStructuresImpl;

import dataStructures.AVLTree;

import static java.lang.Math.max;

/**
 * implementation of AVLTree Interface, explanation of general functions provided on the interface level
 */
public class AVLTreeImpl implements AVLTree {
    // root of current tree
    AVLTreeNode root;

    /**
     * constructor of the class, which set the root attribute
     * @param value first value of the tree
     */
    public AVLTreeImpl(int value) {
        root = new AVLTreeNode(value);
    }

    @Override
    public void insert(int value) {
        // Start of recursive insert by passing the root and value
        insert(root, value);
    }

    /**
     * Inserting the value in the tree, and then study to check if tree is unbalanced and if it is then rotate until it become balanced
     * @param node nodes of the tree based on recursive call
     * @param value the value we want to enter in the tree
     * @return
     */
    public AVLTreeNode insert(AVLTreeNode node, int value) {
        // if node is null create new node and insert that in the tree
        if (node == null) {
            return new AVLTreeNode(value);
        }

        // check the value of the current node and call the function recursively
        if (node.value > value) {
            node.left = insert(node.left, value);
        } else if (node.value < value) {
            node.right = insert(node.right, value);
        } else {
            // if the value exist in the tree return node
            return node;
        }

        // calculate the height of current node
        node.height = 1 + max(getHight(node.left), getHight(node.right));

        // check whether its has balance or not
        int balance = getBalance(node);

        // case left Unbalance and inserted in left of left subtree
        if (balance > 1 && value < node.left.value) {
            // we just need one right rotate
            return rightRotate(node);
        }

        // case right unbalance and inserted in right of right subtree
        if (balance < -1 && value > node.right.value) {
            // we just need one left rotate
            return leftRotate(node);
        }

        // case left unbalance and inserted in right of left subtree
        if (balance > 1 && value > node.left.value) {
            // first we rotate the left node with left rotate and then the current node with right rotate
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // case right unbalance and inserted in left of right subtree
        if (balance < -1 && value < node.right.value) {
            // first we rotate the right node with right rotate and then the current node with left rotate
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // if it's balanced, so we return the node pointer itself
        return node;
    }

    @Override
    public void delete(int value) {
        // Start of recursive delete by passing the root and value
        delete(root, value);
    }

    private AVLTreeNode delete(AVLTreeNode node, int value) {
        // if the node is not exist, return null
        if (node == null) {
            return null;
        }

        // if the node value is more than input value go left, else go right
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // in case both right child and left child are null, return null, else if one of them is null but not both, switch the
            // current with it's not null child, else find the min value at right, switch the min value with current node value, and
            // delete the min value from the tree
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null ^ node.right == null) {
                node = node.right == null ? node.left : node.right;
            } else {
                node.value = minValueNode(node.right).value;
                node.right = delete(node.right, node.value);
            }
        }

        // update the current node height
        node.height = max(getHight(node.left), getHight(node.right)) + 1;

        // check whether it has balance
        int balance = getBalance(node);

        // case left Unbalance and weight of nodes are more under left child
        if (balance > 1 && getBalance(node.left) >= 0) {
            // we just need one right rotate
            return rightRotate(node);
        }

        // case right Unbalance and weight of nodes are more under right child
        if (balance < -1 && getBalance(node.left) < 0) {
            // we just need one left rotate
            return leftRotate(node);
        }

        // case left Unbalance and weight of nodes are more under right child
        if (balance > 1 && getBalance(node.left) < 0) {
            // first we rotate the left node with left rotate and then the current node with right rotate
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // case right Unbalance and weight of nodes are more under left child
        if (balance < -1 && getBalance(node.left) >= 0) {
            // first we rotate the right node with right rotate and then the current node with left rotate
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * private methode for finding the min by traversing to the most left node recursively
     * @param node
     * @return the min node
     */
    private AVLTreeNode minValueNode(AVLTreeNode node) {
        AVLTreeNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    @Override
    public boolean search(int value) {
        // Start of recursive search by passing the root and value
        return search(root, value);
    }

    /**
     * recursive way of looking up the node
     * @param node
     * @param value
     * @return if found true, else false
     */
    private boolean search(AVLTreeNode node, int value) {
        // by starting from root, here we put break point for if we didn't find the value, we return false
        // in function chains
        if (node == null) {
            return false;
        }

        // check the value, if it's greater, recursively calling the right, else calling the left
        if (node.value > value) {
            return search(node.left, value);
        } else if (node.value < value) {
            return search(node.right, value);
        }

        return true;
    }


    /**
     * helper function to get height, if it is null return 0, else return height
     * @param node
     * @return height
     */
    private int getHight(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * return the balance of the node, if it is negative it means the right has more nodes, else means the left has more nodes
     * @param node
     * @return
     */
    private int getBalance(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }

        return getHight(node.left) - getHight(node.right);
    }

    /**
     * rotate the node in clockwise in right direction, meaning getting the left node of current node and swap it with current
     * and then set the right of the left node to current node left, and in the end updating the height of changed nodes
     * @param node to perfom rotation on
     * @return the pointer to the new parent
     */
    private AVLTreeNode rightRotate(AVLTreeNode node) {
        // pointing to left node of current node
        AVLTreeNode left = node.left;
        // pointing to right node of left node of current node
        AVLTreeNode leftRight = left.right;

        // pointing the left's right pointer to the current node
        left.right = node;
        // pointing the left of current node to the right of the left of the current node
        node.left = leftRight;

        // first updating the current node height since it swapped and come one level under the left node
        node.height = max(getHight(node.left), getHight(node.right)) + 1;
        // and then update the left node height since it become the new parent
        left.height = max(getHight(left.left), getHight(left.right)) + 1;

        return left;
    }

    /**
     * rotate the node in counterclockwise in left direction, meaning getting the right node of current node and swap it with current
     * and then set the left of the right node to current node right, and in the end updating the height of changed nodes
     * @param node to perfom rotation on
     * @return the pointer to the new parent
     */
    private AVLTreeNode leftRotate(AVLTreeNode node) {
        // pointing to right node of current node
        AVLTreeNode right = node.right;
        // pointing to left node of right node of current node
        AVLTreeNode rightLeft = right.left;

        // pointing the right's left pointer to the current node
        right.left = node;
        // pointing the right of current node to the left of the right of the current node
        node.right = rightLeft;

        // first updating the current node height since it swapped and come one level under the right node
        node.height = max(getHight(node.left), getHight(node.right)) + 1;
        // and then update the right node height since it become the new parent
        right.height = max(getHight(right.left), getHight(right.right)) + 1;

        return right;
    }

    /**
     * AVLTree Node class, containing the value of the node, height of node and two pointers to the left and right nodes
     */
    class AVLTreeNode {
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


