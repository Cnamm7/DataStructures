package dataStructuresImpl;

import dataStructures.BinarySearchTree;

public class BinarySearchTreeImpl implements BinarySearchTree {
    public BinaryTreeNode root;
    int size = 0;

    @Override
    public void insert(int value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        if (root == null) {
            root = node;
        } else {
            BinaryTreeNode temp = this.root;
            while (true) {
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
        BinaryTreeNode temp = root;
        BinaryTreeNode beforeTemp = root;
        if (root == null) {
            return false;
        }

        while (true) {
            if (value > temp.value) {
                if(temp.right == null) {
                    return false;
                }
                beforeTemp = temp;
                temp = temp.right;
            } else if (value < temp.value) {
                if (temp.left == null) {
                    return false;
                }
                beforeTemp = temp;
                temp = temp.left;
            } else {
                break;
            }
        }

        if (temp.right != null) {
            BinaryTreeNode beforeAfterTemp = null;
            BinaryTreeNode afterTemp = temp.right;
            while (afterTemp.left != null) {
                beforeAfterTemp = afterTemp;
                afterTemp = afterTemp.left;
            }
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
            if (temp == root) {
                root = temp.left;
            }
            temp.value = temp.left.value;
            temp.right = temp.left.right;
            temp.left = temp.left.left;
        } else {
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
        BinaryTreeNode node = root;

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
        return this.root;
    }

    @Override
    public boolean rLookup(int value) {
        return rLookup(root, value);
    }

    private boolean rLookup(BinaryTreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value > node.value) {
            return rLookup(node.right, value);
        } else if (value < node.value) {
            return rLookup(node.left, value);
        }
        return true;
    }

    @Override
    public void rRemove(int value) {
        rRemove(root, value);
    }

    private BinaryTreeNode rRemove(BinaryTreeNode node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            if(node.right == null && node.left == null) {
                this.size--;
                return null;
            } else if (node.right == null ^ node.left == null) {
                node = node.right == null ? node.left : node.right;
            } else {
                node.value = findMIN(node.right).value;
                node.right = rRemove(node.right, value);
            }
            this.size--;
        } else if (node.value < value) {
            node.right = rRemove(node.right, value);
        } else if (node.value > value) {
            node.left = rRemove(node.left, value);
        }
        return node;
    }

    private BinaryTreeNode findMIN(BinaryTreeNode node) {
        if (node.left != null) {
            return findMIN(node.left);
        } else {
            return node;
        }
    }

    @Override
    public void rInsert(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
            size++;
        }
        rInsert(root, value);
    }

    private BinaryTreeNode rInsert(BinaryTreeNode node, int value) {
        if (node == null) {
            this.size++;
            return new BinaryTreeNode(value);
        }

        if (value > node.value) {
            node.right = rInsert(node.right, value);
        } else if (value < node.value) {
            node.left = rInsert(node.left, value);
        }

        return node;
    }

    public int size() {
        return this.size;
    }

    /*
    To Do
     */
    @Override
    public void print() {

    }

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

    public class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
