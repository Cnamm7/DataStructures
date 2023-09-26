package dataStructuresImpl;


import dataStructures.Graph;

import java.util.*;

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

    @Override
    public void printWithBFS(String vertex) {
        if (!adjList.containsKey(vertex)) {
            System.out.println("no such a vertex in this graph!");
        }

        Set<String> seen = new HashSet<>();
        Queue<String> BFSQueue = new LinkedList<>();

        BFSQueue.add(vertex);

        while (BFSQueue.size() > 0) {
            String current = BFSQueue.remove();

            if (!seen.contains(current)) {
                System.out.println(current + " ");
                seen.add(current);
            }

            for (String vertecis : adjList.get(current)) {
                if (!seen.contains(vertecis)) {
                    BFSQueue.add(vertecis);
                }
            }
        }
    }

    @Override
    public void printWithDFS(String vertex) {
        if (!adjList.containsKey(vertex)) {
            System.out.println("no such a vertex in this graph!");
        }

        Set<String> seen = new HashSet<>();
        Stack<String> BFSQueue = new Stack<>();

        BFSQueue.push(vertex);

        while (BFSQueue.size() > 0) {
            String current = BFSQueue.pop();

            if (!seen.contains(current)) {
                System.out.println(current + " ");
                seen.add(current);
            }

            for (String vertecis : adjList.get(current)) {
                if (!seen.contains(vertecis)) {
                    BFSQueue.push(vertecis);
                }
            }
        }
    }
}
