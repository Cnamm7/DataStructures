package dataStructures;

public interface Graph {
    public boolean addVertex(String vertex);
    public boolean addEdge(String vertex1, String vertex2);
    public boolean removeVertex(String vertex);
    public boolean removeEdge(String vertex1, String vertex2);
    public void printGraph();
    public void printWithBFS(String vertex);
    public void printWithDFS(String vertex);
}
