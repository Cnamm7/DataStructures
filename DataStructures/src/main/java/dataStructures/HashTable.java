package dataStructures;

import java.util.Set;

/**
 * implementing the HashTable data structures with different methods
 */
public interface HashTable {
    /**
     * set method for setting the key with the assigned value
     * @param key
     * @param value
     */
    public void set(String key, int value);

    /**
     * getting the value with the refrenced key
     * @param key
     * @return
     */
    public int get(String key);

    /**
     * get all the keys of this HashTable
     * @return
     */
    public Set<String> getKeys();

    /**
     * printing the table
     */
    public void printTable();
}
