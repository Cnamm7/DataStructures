package dataStructuresImpl;

import dataStructures.HashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTableImpl implements HashTable {
    int size = 7;
    HashTableNode[] hashTable;

    public HashTableImpl() {
        hashTable = new HashTableNode[size];
    }

    @Override
    public void set(String key, int value) {
        int index = hash(key);
        HashTableNode node = new HashTableNode(key, value);
        if (this.hashTable[index] == null) {
            this.hashTable[index] = node;
        } else {
            HashTableNode temp = this.hashTable[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public int get(String key) {
        int index = hash(key);
        HashTableNode temp = this.hashTable[index];
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
        Set<String> keys = new HashSet<>();
        HashTableNode temp;
        for (int i = 0; i < this.size; i++) {
            temp = this.hashTable[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    @Override
    public void printTable() {
        HashTableNode temp;
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

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % this.size;
        }
        return hash;
    }

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
