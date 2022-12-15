package graph;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import interfaces.AlgorithmPlugin;
import interfaces.NodePlugin;
import loader.PluginLoader;

public class Main {
	
	public static void main(String[] args) {
		createGraphFromUserInput();
    }

    private static void createGraphFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Should the graph have weighted edges? Enter 'true' for yes and 'false' for no:");
            boolean weighted = scanner.nextBoolean();

            System.out.println("Should the graph have directed edges? Enter 'true' for yes and 'false' for no:");
            boolean directed = scanner.nextBoolean();

            createGraph(weighted, directed);

            System.out.println("\n\nDo you want to change the graphs features? Enter 'true' for yes and 'false' for no:");
            if (scanner.nextBoolean()) {
            	createGraphFromUserInput();
            }
            scanner.close();
        } catch (Exception e) {
        	 System.out.println(e);
            System.out.println("Invalid input. Please try again.");
            createGraphFromUserInput();
        }
    }

    private static void createGraph(boolean weighted, boolean directed) {
        Node node1 = new Node("1", Color.green);
        Node node2 = new Node("2", Color.red);
        Node node3 = new Node("3", Color.blue);
        Node node4 = new Node("4", Color.yellow);
        Node node5 = new Node("5", Color.black);
        
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

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
        
        List<NodePlugin> nodePlugins = PluginLoader.load(NodePlugin.class);
    	List<AlgorithmPlugin> algorithms = PluginLoader.load(AlgorithmPlugin.class);
    	
    	Graph graph = new Graph(nodes, edges, nodePlugins, weighted, directed);
    	
        for (AlgorithmPlugin algorithm: algorithms) {
        	algorithm.execute(graph);
        }
    }
}

