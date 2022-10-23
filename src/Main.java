import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5s");
      

        Edge edge12 = new Edge(node1, node2, 1);
        Edge edge13 = new Edge(node1, node3, 2);
        Edge edge23 = new Edge(node2, node3, 3);
        Edge edge24 = new Edge(node2, node4, 4);
        Edge edge34 = new Edge(node3, node4, 5);
        Edge edge35 = new Edge(node3, node5, 6);
        Edge edge45 = new Edge(node4, node5, 7);

        LinkedList<Edge> edges = new LinkedList<Edge>();
        edges.add(edge12);
        edges.add(edge13);
        edges.add(edge23);
        edges.add(edge24);
        edges.add(edge34);
        edges.add(edge35);
        edges.add(edge45);

        Graph graph = new Graph(5, edges);
        graph.minimumSpanningTree();
        graph.depthFirstSearch(graph.getEdges().getFirst().getSource());
    }
}

