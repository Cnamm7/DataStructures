package dataStructures;

/**
 * implementing Graph data structure with different methods
 */
public interface Graph {
    /**
     * a function to add vertex to the graph
     * @param vertex
     * @return true if it adds it, or false if the graph already contains it
     */
    public boolean addVertex(String vertex);

    /**
     * its going to add an edge between two vertex
     * @param vertex1
     * @param vertex2
     * @return true if it is successfully and false if we don't have one or both of the vertexes
     */
    public boolean addEdge(String vertex1, String vertex2);

    /**
     * first remove the edges connected to vertex and then remove the vertex at the end
     * @param vertex
     * @return true if it removed, or false if the graph does not contain the vertex
     */
    public boolean removeVertex(String vertex);

    /**
     * it's going to remove vertexes connection by removing them from each other list
     * @param vertex1
     * @param vertex2
     * @return true if it was successful, false if graph don't have one or both of the vertexes
     */
    public boolean removeEdge(String vertex1, String vertex2);

    /**
     * it's simply going to print adjList HashMap
     */
    public void printGraph();

    /**
     * it's going to print the vertexes with Breadth First Search technique, and showing the layer by layer view
     * @param vertex
     */
    public void printWithBFS(String vertex);

    /**
     * it's going to print the vertexes with Depth First Search technique, and showing the deep traversal view
     * @param vertex
     */
    public void printWithDFS(String vertex);
}
