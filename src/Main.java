import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getUserInput();
    }

    private static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Should the graph have labeled nodes? Enter 'true' for yes and 'false' for no:");
            boolean labeled = scanner.nextBoolean();

            System.out.println("Should the graph have weighted edges? Enter 'true' for yes and 'false' for no:");
            boolean weighted = scanner.nextBoolean();

            System.out.println("Should the graph have directed edges? Enter 'true' for yes and 'false' for no:");
            boolean directed = scanner.nextBoolean();

            createGraph(labeled, weighted, directed);

            System.out.println("\n\nDo you want to change the graphs features? Enter 'true' for yes and 'false' for no:");
            if (scanner.nextBoolean()) {
                getUserInput();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            getUserInput();
        }
    }

    private static void createGraph(boolean labeled, boolean weighted, boolean directed) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        Edge edge12 = new Edge(node1, node2, 1);
        Edge edge13 = new Edge(node1, node3, 2);
        Edge edge23 = new Edge(node2, node3, 3);
        Edge edge24 = new Edge(node2, node4, 4);
        Edge edge34 = new Edge(node3, node4, 5);
        Edge edge35 = new Edge(node3, node5, 6);
        Edge edge45 = new Edge(node4, node5, 7);

        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(edge12);
        edges.add(edge13);
        edges.add(edge23);
        edges.add(edge24);
        edges.add(edge34);
        edges.add(edge35);
        edges.add(edge45);

        IGraph graph = new Graph(5, edges);
        if (labeled) {
            graph = new LabeledGraph(graph);
        }
        if (weighted) {
            graph = new WeightedGraph(graph);
        }
        if (directed) {
            graph = new DirectedGraph(graph);
        }

        graph.minimumSpanningTree();
        graph.depthFirstSearch(node1);
    }
}

