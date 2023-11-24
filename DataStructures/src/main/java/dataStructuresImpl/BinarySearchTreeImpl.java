package dataStructuresImpl;

import dataStructures.BinarySearchTree;

import java.util.*;

/**
 * implementation of BinarySearchTree Interface, explanation of general functions provided on the interface level
 */
public class BinarySearchTreeImpl implements BinarySearchTree {
    // roo Node of Tree
    public BinaryTreeNode root;
    // initializing the size of Tree
    int size = 0;

    @Override
    public void insert(int value) {
        // first creating a Node from current value
        BinaryTreeNode node = new BinaryTreeNode(value);
        // checking whether the tree is empty and root is equal to null
        if (root == null) {
            root = node;
        } else {
            // creating temp pointer
            BinaryTreeNode temp = this.root;
            // start traversing based on the value of the nodes
            while (true) {
                // if it's less than to current node go to left else go to right, and finally find the null node to insert
                // at the right place
                if (node.value > temp.value) {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else if (node.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    }else {
                        temp = temp.left;
                    }
                }
            }
        }
        this.size++;
    }

    @Override
    public boolean remove(int value) {
        // creating two pointers for tracing the current and previous node
        BinaryTreeNode temp = root;
        BinaryTreeNode beforeTemp = root;
        // if Tree is empty and root is equal null, it's going to return false
        if (root == null) {
            return false;
        }

        // creating a traversal methode to find the value that we want to remove and point to the current
        // node and the previous node in the path
        while (true) {
            // go to the right or go to the left
            if (value > temp.value) {
                // if we require to go to right, and it's null then there is no such value in Tree
                if(temp.right == null) {
                    return false;
                }
                // updating before and current pointers
                beforeTemp = temp;
                temp = temp.right;
            } else if (value < temp.value) {
                // if we require to go to the left, and it's null then there is no such value in Tree
                if (temp.left == null) {
                    return false;
                }
                // updating before and current pointers
                beforeTemp = temp;
                temp = temp.left;
            } else {
                break;
            }
        }

        // ok here we found the node, how to remove it? check what is at the right node first
        // to do the proper remove by rearranging the tree, and if null check left and rearrange accordingly
        // else both are null, and we can simply remove it
        if (temp.right != null) {
            // first creating two pointers one to the right and one to before the one that we want to
            // travers with
            BinaryTreeNode beforeAfterTemp = null;
            BinaryTreeNode afterTemp = temp.right;
            // go to the most left of right node that we put in after Temp
            while (afterTemp.left != null) {
                beforeAfterTemp = afterTemp;
                afterTemp = afterTemp.left;
            }
            // if we traversed and found the most left of right node, then we can simply change the value of
            // that node with the node we want to remove and set the before that node to null, else if we didn't
            // travers and there is no left node to the right node, we simply swap the right node with the node
            // we want to remove
            if (afterTemp != temp.right)  {
                temp.value = afterTemp.value;
                beforeAfterTemp.left = null;
            } else {
                BinaryTreeNode toRemove = temp.right;
                temp.value = toRemove.value;
                temp.right = toRemove.right;
                toRemove.right = null;
                toRemove.left = null;
            }

        } else if (temp.left != null) {
            // here, we know the right is null, and we have the left the one, so we can simply swap the left
            // with the node we want to remove
            if (temp == root) {
                root = temp.left;
            }
            temp.value = temp.left.value;
            temp.right = temp.left.right;
            temp.left = temp.left.left;
        } else {
            // here we know both right and left are null, so we can simply remove the node by putting
            // the previous pointer to null
            if (temp == root) {
                root = null;
            } else {
                if (temp.value > beforeTemp.value) {
                    beforeTemp.right = null;
                } else {
                    beforeTemp.left = null;
                }
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean lookup(int value) {
        // create a pointer to the root
        BinaryTreeNode node = root;

        // simply traverse to find the node, by checking the value and going to the left or right or if
        // equal return true
        while (node != null) {
            if(node.value == value) {
                return true;
            }
            if(node.value > value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    @Override
    public BinaryTreeNode getRoot() {
        // getting the root value
        return this.root;
    }

    @Override
    public boolean rLookup(int value) {
        // start of recursive look up methode by passing the root
        return rLookup(root, value);
    }

    /**
     * recursive way of looking up the node
     * @param node
     * @param value
     * @return if found true, else false
     */
    private boolean rLookup(BinaryTreeNode node, int value) {
        // by starting from root, here we put break point for if we didn't find the value, we return false
        // in function chains
        if (node == null) {
            return false;
        }
        // check the value, if it's greater, recursively calling the right, else calling the left
        if (value > node.value) {
            return rLookup(node.right, value);
        } else if (value < node.value) {
            return rLookup(node.left, value);
        }
        return true;
    }

    @Override
    public void rRemove(int value) {
        // start of recursive remove methode by passing the root
        rRemove(root, value);
    }

    /**
     * recursive way of removing node
     * @param node
     * @param value
     * @return the node that we found and removed
     */
    private BinaryTreeNode rRemove(BinaryTreeNode node, int value) {
        // creating the Break Point for recursive call first with checking if it's null or not
        if (node == null) {
            return null;
        } else if (node.value == value) {
            // here we know we found the value, so we check if both right and left are null, then return null
            // to previous call stack, so we put the pinter of the current node to null
            if(node.right == null && node.left == null) {
                this.size--;
                return null;
            } else if (node.right == null ^ node.left == null) {
                // here we check if right is null or left is null but not both, so we simply point the current node
                // to left or right
                node = node.right == null ? node.left : node.right;
            } else {
                // here we know both values at right and left are not null, so we pass the right node of current to find the
                // most left of that, and then swap the values with current node, and then call rRemove methode on the right node,
                // so it can remove the value we already swap from tree
                node.value = findMIN(node.right).value;
                node.right = rRemove(node.right, node.value);
            }
            this.size--;
        } else if (node.value < value) {
            // here we know value is more than the current node, so we call rRemove on the right recursively
            node.right = rRemove(node.right, value);
        } else if (node.value > value) {
            // here we know value is less than the current node, so we call rRemove on the left recursively
            node.left = rRemove(node.left, value);
        }
        return node;
    }

    /**
     * private methode for finding the min by traversing to the most left node recursively
     * @param node
     * @return the min node
     */
    private BinaryTreeNode findMIN(BinaryTreeNode node) {
        if (node.left != null) {
            return findMIN(node.left);
        } else {
            return node;
        }
    }

    @Override
    public void rInsert(int value) {
        // if the tree is empty, simply create a node and assign it to the tree
        if (root == null) {
            root = new BinaryTreeNode(value);
            size++;
        }
        // start the recursive function by calling it with root
        rInsert(root, value);
    }

    /**
     * recursive way of inserting node
     * @param node
     * @param value
     * @return the node that we inserted
     */
    private BinaryTreeNode rInsert(BinaryTreeNode node, int value) {
        // if node is empty and we traversed to it, then returning the new node with value to previous call stack
        if (node == null) {
            this.size++;
            return new BinaryTreeNode(value);
        }

        // if the value is more than the node value call rInsert function on the right node recursively, else call it
        // on the left node
        if (value > node.value) {
            node.right = rInsert(node.right, value);
        } else if (value < node.value) {
            node.left = rInsert(node.left, value);
        }

        return node;
    }

    @Override
    public int size() {
        // return the size
        return this.size;
    }

    @Override
    public List<Integer> BFS() {
        // creating a queue for first-in first-out feature
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        // creating a list to add values to it
        List<Integer> result = new ArrayList<>();
        // start with pointing to root
        BinaryTreeNode temp = this.root;
        queue.add(temp);
        while(queue.size() > 0) {
            // remove the current first and the add the left and right child if they are not null and then add current to the list
            temp = queue.remove();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            result.add(temp.value);
        }
        return result;
    }

    @Override
    public List<Integer> DFSPreOrder() {
        // creating the list for adding values
        List<Integer> result = new ArrayList<>();

        /**
         * creating the traverse class for adding first parent value and then left and then right
         */
        class Traverse {
            Traverse(BinaryTreeNode current) {
                result.add(current.value);
                if (current.left != null) {
                    new Traverse(current.left);
                }
                if (current.right != null) {
                    new Traverse(current.right);
                }
            }
        }

        new Traverse(root);
        return result;
    }

    @Override
    public List<Integer> DFSPostOrder() {
        // creating the list for adding values
        List<Integer> result = new ArrayList<>();

        /**
         * creating the traverse class for adding first left value and then right and then parent
         */
        class Traverse{
            Traverse(BinaryTreeNode current) {
                if (current.left != null) {
                    new Traverse(current.left);
                }
                if (current.right != null) {
                    new Traverse(current.right);
                }
                result.add(current.value);
            }
        }
        new Traverse(root);
        return result;
    }

    @Override
    public List<Integer> DFSInOrder() {
        // creating the list for adding values
        List<Integer> result = new ArrayList<>();

        /**
         * creating the traverse class for adding first left value and then parent and then right
         */
        class Traverse{
            Traverse(BinaryTreeNode current) {
                if (current.left != null) {
                    new Traverse(current.left);
                }
                result.add(current.value);
                if (current.right != null) {
                    new Traverse(current.right);
                }

            }
        }
        new Traverse(root);
        return result;
    }

    /*
    to be used in print
     */
    private int maxLevelFinder() {
        if (root == null) {
            return 0;
        }
        int minValueInTreeLevel = 1;
        int maxValueInTreeLevel = 1;

        BinaryTreeNode temp = root;
        while (temp.left != null) {
            minValueInTreeLevel++;
            temp = temp.left;
        }

        temp = root;
        while (temp.right != null) {
            maxValueInTreeLevel++;
            temp = temp.right;
        }

        return Math.max(minValueInTreeLevel, maxValueInTreeLevel);
    }

    /**
     * Node for BinaryTree, has a value for current node and two pointers, one to the left side node and one to the right side node
     */
    public class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
