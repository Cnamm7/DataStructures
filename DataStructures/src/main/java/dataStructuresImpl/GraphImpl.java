package dataStructuresImpl;

import dataStructures.Graph;
import java.util.*;

/**
 * Implementation of Graph Interface, explanation of general functions provided on the interface level
 */
public class GraphImpl implements Graph {
    private final HashMap<String, List<String>> adjList = new HashMap<>();

    @Override
    public boolean addVertex(String vertex) {
        // checks if it contains key
        if(this.adjList.containsKey(vertex)) { return false; }
        // adding the vertex to the adjList
        this.adjList.put(vertex, new ArrayList<>());
        return true;
    }

    @Override
    public boolean addEdge(String vertex1, String vertex2) {
        // checking whether two vertexes are available
        if(this.adjList.containsKey(vertex1) && this.adjList.containsKey(vertex2)) {
            this.adjList.get(vertex1).add(vertex2);
            this.adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(String vertex) {
        // first check if our adjList contains vertex
        if(this.adjList.containsKey(vertex)) {
            // creating temporary list from vertexes connections
            List<String> tempList = new ArrayList<>(this.adjList.get(vertex));
            // first it's going to remove all the edges by traversing throw the connections and removing the
            // vertex from their list
            for(int i = 0; i < tempList.size(); i++) {
                this.removeEdge(tempList.get(i), vertex);
            }
            // and now it can remove the vertex itself
            this.adjList.remove(vertex);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(String vertex1, String vertex2) {
        // check if both vertexes are available first
        if(this.adjList.containsKey(vertex1) && this.adjList.containsKey(vertex2)) {
            // simply remove the vertex 2 from vertex 1 list of connections
            this.adjList.get(vertex1).remove(vertex2);
            // simply remove the vertex 1 from vertex 2 list of connections
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
        // checks whether vertex exists
        if (!adjList.containsKey(vertex)) {
            System.out.println("no such a vertex in this graph!");
        }
        // creating the list of already seen vertexes
        Set<String> seen = new HashSet<>();
        // creating Queue for first-in first-out functionality, the reason is we are going to remove parent fist, and then the child
        // of that parent
        Queue<String> BFSQueue = new LinkedList<>();
        // adding the first vertex to start the search
        BFSQueue.add(vertex);
        // creating a while loop for iterating until the end of the list
        while (BFSQueue.size() > 0) {
            // getting the current and the head of the Queue
            String current = BFSQueue.remove();
            // if it is not in already seen list it's going to print that and add it to already seen list
            if (!seen.contains(current)) {
                System.out.println(current + " ");
                seen.add(current);
            }
            // going to add all the connections that the current vertex has with others, if they are already not have been seen
            for (String vertecis : adjList.get(current)) {
                if (!seen.contains(vertecis)) {
                    BFSQueue.add(vertecis);
                }
            }
        }
    }

    @Override
    public void printWithDFS(String vertex) {
        // checks whether vertex exists
        if (!adjList.containsKey(vertex)) {
            System.out.println("no such a vertex in this graph!");
        }
        // creating the list of already seen vertexes
        Set<String> seen = new HashSet<>();
        // creating Stack for Last-in first-out functionality, the reason is for start from a vertex and go as far as it can deeply
        // into the given path, and then come back and go in another unexplored path
        Stack<String> BFSQueue = new Stack<>();
        // adding the first vertex to start the search
        BFSQueue.push(vertex);
        // creating a while loop for iterating until the end of the list
        while (BFSQueue.size() > 0) {
            // getting the current and the head of the Stack
            String current = BFSQueue.pop();
            // if it is not in already seen list it's going to print that and add it to already seen list
            if (!seen.contains(current)) {
                System.out.println(current + " ");
                seen.add(current);
            }
            // going to add all the connections that the current vertex has with others, if they are already not have been seen
            for (String vertecis : adjList.get(current)) {
                if (!seen.contains(vertecis)) {
                    BFSQueue.push(vertecis);
                }
            }
        }
    }
}
