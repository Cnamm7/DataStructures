package Main;

import dataStructuresImpl.*;
import dataStructures.*;
import customException.DataStructuresExeption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void sortStack(Stack stack) {
        Stack<Integer> sortedStack = new Stack();
        while (!stack.isEmpty()) {
            int temp = (int)stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());
            }

            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

    }

    public static class MainBinarySearch {
        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTreeImpl();
            tree.insert(18);
            System.out.println("root: " + tree.getRoot().value);
            tree.insert(15);
            System.out.println("root.left: " + tree.getRoot().left.value);
            tree.insert(14);
            System.out.println("root.left.left: " + tree.getRoot().left.left.value);
            System.out.println("root.right: " + tree.getRoot().right);
            tree.insert(19);
            System.out.println("root.right: " + tree.getRoot().right.value);
            System.out.println("root.left.right: " + tree.getRoot().left.right);
            tree.insert(17);
            System.out.println("root.left.right: " + tree.getRoot().left.right.value);

            System.out.println("now remove");
            System.out.println("is 17 in tree: " + tree.lookup(17));
            tree.remove(17);
            System.out.println("now what? " + tree.lookup(17));
            tree.insert(16);
            tree.remove(15);
            System.out.println(tree.lookup(15));
            System.out.println("root.left: " + tree.getRoot().left.value);
            System.out.println("16 is there? " + tree.rLookup(16));

            System.out.println("===========================================");
            BinarySearchTree recursiveTree = new BinarySearchTreeImpl();
            recursiveTree.rInsert(10);
            System.out.println(recursiveTree.size());
            System.out.println(recursiveTree.rLookup(10));
            recursiveTree.rInsert(11);
            recursiveTree.rInsert(8);
            recursiveTree.rInsert(4);
            recursiveTree.rInsert(15);
            System.out.println(recursiveTree.size());
            recursiveTree.remove(4);
            System.out.println(recursiveTree.size());
            System.out.println(recursiveTree.rLookup(4));
        }
    }

    public static class SortMain{
        public static void main(String[] args) {
            Sort sort= new SortImpl();
            int[] arr = {12, 3, 1, 8, 4, 11};
            System.out.println(Arrays.toString(arr));
            sort.bubbleSort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println("===================");
            int[] arr1 = {12, 3, 1, 8, 4, 11};
            System.out.println(Arrays.toString(arr1));
            sort.selectionSort(arr1);
            System.out.println(Arrays.toString(arr1));
            System.out.println("===================");
            int[] arr2 = {12, 3, 1, 8, 4, 11};
            System.out.println(Arrays.toString(arr2));
            sort.insertionSort(arr2);
            System.out.println(Arrays.toString(arr2));
            System.out.println("===================");
            int[] arr3 = {12, 3, 1, 8, 4, 11};
            System.out.println(Arrays.toString(arr3));
            int [] resoponse = sort.mergeSort(arr3);
            System.out.println(Arrays.toString(resoponse));

        }
    }

    public class MainHashTable {
        public static void main(String[] args) {
            HashTable table = new HashTableImpl();
            table.set("Sina", 100);
            table.set("Saba", 50);
            table.set("Baba", 1000);
            table.set("Maman", 1500);
            table.set("Alvin", 10);
            table.printTable();
            System.out.println(table.get("Saba"));
            Set<String> keys = table.getKeys();
            for (String key : keys) {
                System.out.println(key);
            }
        }

        public static class MainGraph {
            public static void main(String[] args) {
                Graph graph = new GraphImpl();

                graph.addVertex("A");
                graph.addVertex("B");
                graph.addVertex("C");
                graph.addVertex("D");

                graph.addEdge("A", "B");
                graph.addEdge("C", "B");
                graph.addEdge("D", "B");
                graph.addEdge("A", "D");
                graph.addEdge("A", "C");

                //graph.removeEdge("B", "D");
                graph.removeVertex("B");

                graph.printGraph();
            }
        }

        public static class MainOfHeap {
            public static void main(String[] args) {
                Heap heap = new HeapImpl();
                heap.insert(12);
                heap.insert(14);
                heap.insert(15);
                heap.insert(16);
                heap.insert(17);
                heap.insert(18);
                heap.printHeap();
                heap.remove();
                heap.printHeap();
            }
        }
    }

    public class MainOfLinkedList {
        public static void main(String[] args) throws DataStructuresExeption {
            LinkedList list = new LinkedListImpl(1);
            list.print();
            list.append(2);
            list.print();
            list.append(3);
            list.print();
            list.prepend(4);
            list.print();
            list.insert(2, 8);
            list.print();
            List<Integer> test = new ArrayList<>();
            test.add(1);
            test.add(2);
            LinkedList list1 = new LinkedListImpl(test);
            list1.print();
            list1.insert(1, test);
            list1.print();
            list.insert(2, new int[]{1,2,3});
            list.print();
            System.out.println("----------");
            list.getHead();
            list.getTail();
            list.getLength();
            System.out.println("----------");
            list1.getHead();
            list1.getTail();
            list1.getLength();
            LinkedList list2 = new LinkedListImpl();
            list2.prepend(1);
            list2.print();
            list2.removeLast();
            list2.print();
            list1.print();
            list1.getLength();
            list1.removeLast();
            list1.getLength();
            list1.print();
            list1.removeFirst();
            list1.print();
            list1.removeLast();
            list1.print();
            list.print();
            System.out.println(list.get(3).getValue());
            System.out.println(list.get(7).getValue());
            list.set(7, 90);
            System.out.println(list.get(7).getValue());
            list.print();
            list.remove(2);
            list.print();
            list.reverse();
            list.print();
            list.reverse();
            list.print();
            System.out.println(list.findMiddleNode().getValue());
            list1.print();
            list1.append(1);
            list1.append(3);
            list1.append(4);
            list1.print();
            System.out.println(list1.findMiddleNode().getValue());
            System.out.println(list.hasLoop());
            list1.append(2);
            System.out.println(list1.hasLoop());
        }
    }

    public class MainOfStackAndQueue {
        public static void main(String[] args) throws DataStructuresExeption {
            StackLinkedList stack = new StackLinkedListImpl(11);
            stack.print();
            stack.getTop();
            stack.push(12);
            stack.print();
            stack.getTop();
            stack.printHeight();
            stack.push(13);
            stack.push(14);
            stack.print();
            stack.printHeight();
            stack.pop();
            stack.printHeight();
            stack.print();

            Queue queue = new QueueImpl(0);
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.printFirstAndList();
            queue.printLength();
            queue.printQueue();
            queue.dequeue();
            queue.printFirstAndList();
            queue.printLength();
            queue.printQueue();
        }
    }
}