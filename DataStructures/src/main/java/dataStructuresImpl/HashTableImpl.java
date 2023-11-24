package dataStructuresImpl;

import dataStructures.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * implementation of HashTable Interface with LinkedList strategy for collision, explanation of general functions provided on the interface level
 */
public class HashTableImpl implements HashTable {
    // setting the size to a prime number of choice
    int size = 7;
    // creating an array of hash table nodes
    HashTableNode[] hashTable;

    // constructor of this class, creating the hashtable with the size
    public HashTableImpl() {
        hashTable = new HashTableNode[size];
    }

    @Override
    public void set(String key, int value) {
        // getting the index by calling the hash function
        int index = hash(key);
        // creating the node of hash table with key and value pairs
        HashTableNode node = new HashTableNode(key, value);
        // if the index is null and no node is there, set the node to that place
        if (this.hashTable[index] == null) {
            this.hashTable[index] = node;
        } else {
            // here we know there is another node in this place, so we create a temp pointer to that node
            HashTableNode temp = this.hashTable[index];
            // traverse through nodes until we reach null and end of the list
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public int get(String key) {
        // getting the index by hash function
        int index = hash(key);
        // setting a pointer to the returned index
        HashTableNode temp = this.hashTable[index];
        // traverse through linked list to find the value
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    @Override
    public Set<String> getKeys() {
        // create a set to add all the keys to it
        Set<String> keys = new HashSet<>();
        // create a pointer for traversing
        HashTableNode temp;
        for (int i = 0; i < this.size; i++) {
            // going through array indexes
            temp = this.hashTable[i];
            // while temp is not null add the keys in linkedList
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    @Override
    public void printTable() {
        // create a pointer to the current node
        HashTableNode temp;
        // traverse through the array and print each position and linkedList in it
        for (int i = 0; i < this.size; i++) {
            System.out.print(i + ": ");
            temp = this.hashTable[i];
            while (temp != null) {
                System.out.print("{key: " + temp.key + ", value: " + temp.value + "} ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    /**
     * private hash function to create a hash value from the key, and ensuring that it will be in the array index range
     * by calculating the remainder value
     * @param key
     * @return
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % this.size;
        }
        return hash;
    }

    /**
     * Node of this hash table, which contains key and value pairs, and a pointer to the next node
     */
    private class HashTableNode {
        String key;
        int value;
        HashTableNode next;

        public HashTableNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
