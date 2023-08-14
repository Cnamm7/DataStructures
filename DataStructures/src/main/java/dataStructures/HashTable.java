package dataStructures;

import java.util.Set;

public interface HashTable {
    public void set(String key, int value);
    public int get(String key);
    public Set<String> getKeys();
    public void printTable();
}
