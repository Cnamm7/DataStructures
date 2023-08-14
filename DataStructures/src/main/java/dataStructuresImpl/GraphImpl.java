package dataStructuresImpl;


import dataStructures.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphImpl implements Graph {
    private final HashMap<String, List<String>> adjList = new HashMap<>();

    @Override
    public boolean addVertex(String vertex) {
        if(this.adjList.containsKey(vertex)) { return false; }
        this.adjList.put(vertex, new ArrayList<>());
        return true;
    }

    @Override
    public boolean addEdge(String vertex1, String vertex2) {
        if(this.adjList.containsKey(vertex1) && this.adjList.containsKey(vertex2)) {
            this.adjList.get(vertex1).add(vertex2);
            this.adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(String vertex) {
        if(this.adjList.containsKey(vertex)) {
            List<String> tempList = new ArrayList<>(this.adjList.get(vertex));
            for(int i = 0; i < tempList.size(); i++) {
                this.removeEdge(tempList.get(i), vertex);
            }
            this.adjList.remove(vertex);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(String vertex1, String vertex2) {
        if(this.adjList.containsKey(vertex1) && this.adjList.containsKey(vertex2)) {
            this.adjList.get(vertex1).remove(vertex2);
            this.adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    @Override
    public void printGraph() {
        System.out.println(this.adjList);
    }
}
