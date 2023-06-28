import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Edge2> edges = new ArrayList<>();

        edges.add(new Edge2(0,1,6));
        edges.add(new Edge2(1,2,5));
        edges.add(new Edge2(2,0,8));
        edges.add(new Edge2(2,1,3));
        edges.add(new Edge2(3,2,9));
        edges.add(new Edge2(4,5,1));
        edges.add(new Edge2(5,4,3));

        Graph2 graph2 = new Graph2(edges);
        Util2.printGraph(graph2);
    }
}

class Edge2 {
    private int source, destination, weight;

    public Edge2(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Node2 {
    private int value, weight;

    public Node2(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.value + " (" + this.weight + ")";
    }
}

class Graph2 {
    private List<List<Node2>> adjacencyList = new ArrayList<>();

    public Graph2(List<Edge2> edges) {
        int vertex = 0;

        for (Edge2 edge : edges)
            vertex = Integer.max(vertex, Integer.max(edge.getSource(), edge.getDestination()));


        // allocate memory for the adjacency list
        for (int i = 0; i <= vertex; i++) {
            adjacencyList.add(i, new LinkedList<>());
        }

        // adding edges to directed graph
        for (Edge2 current : edges) {
            // allocate a new node in the adjacency list from source to destination
            adjacencyList.get(current.getSource()).add(new Node2(current.getDestination(), current.getWeight()));

            // for undirected Graph
            // allocate a new node in the adjacency list from destination to source
            // adjList.get(current.dest).add(new Node(current.getSource(), current.getWeight()));
        }
    }

    public List<List<Node2>> getAdjacencyList() {
        return adjacencyList;
    }
}


class Util2 {
    public static void printGraph(Graph2 graph) {
        int source = 0;
        int size = graph.getAdjacencyList().size();

        if (source < size) {
            do {
                for (Node2 dest : graph.getAdjacencyList().get(source)) {
                    System.out.print("[" + source + "—> " + dest + "]");
                }
                System.out.println();
                source++;
            } while (source < size);
        }
    }
}