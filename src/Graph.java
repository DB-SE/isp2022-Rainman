import java.util.Collections;
import java.util.LinkedList;

public class Graph {
    private int numberOfNodes;
    private LinkedList<Edge> edges;

    public Graph(int numberOfNodes, LinkedList<Edge> edges) {
        this.numberOfNodes = numberOfNodes;
        this.edges = edges;
    }

    public void minimumSpanningTree() {
        Collections.sort(edges);

    }

    public void depthFirstSearch() {

    }
}
