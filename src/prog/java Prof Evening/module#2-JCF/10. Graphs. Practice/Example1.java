import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1));
        edges.add(new Edge(1,2));
        edges.add(new Edge(2,0));
        edges.add(new Edge(2,1));
        edges.add(new Edge(3,2));
        edges.add(new Edge(4,5));
        edges.add(new Edge(3,4));

        Graph graph = new Graph(edges);
        Util.printGraph(graph);

    }
}

class Edge {
    private int source;
    private int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}

class Graph {
    private List<List<Integer>> adjacencyList = new ArrayList<>();

    public Graph(List<Edge> edges) {
        int vertex = 0;

        for (Edge edge : edges)
            vertex = Integer.max(vertex, Integer.max(edge.getSource(), edge.getDestination()));

        // allocating memory for the adjacency list
        for (int i = 0; i <= vertex; i++)
            adjacencyList.add(i, new LinkedList<>());

        for (Edge current : edges) {

            // allocate a new node in the adjacency list from source to destination
            adjacencyList.get(current.getSource()).add(current.getDestination());

            // for undirected Graph
            // allocate a new node in the adjacency list from destination to source
            // adjList.get(current.dest).add(current.getSource());
        }
    }

    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}

class Util {
    public static void printGraph(Graph graph) {
        int source = 0;
        int size = graph.getAdjacencyList().size();

        if (source < size) {
            do {
                for (int dest : graph.getAdjacencyList().get(source)) {
                    System.out.print("[" + source + "—> " + dest + "]");
                }
                System.out.println();
                source++;
            } while (source < size);
        }
    }
}