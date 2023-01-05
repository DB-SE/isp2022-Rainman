import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	ArrayList<Graph> graphs = new ArrayList<Graph>();
	
	protected void run() {
	
		Node node1 = new Node();
	    Node node2 = new Node();
	    Node node3 = new Node();
	    Node node4 = new Node();
	    Node node5 = new Node();
	    
	    LinkedList<Node> nodes = new LinkedList<Node>();
	    nodes.add(node1);
	    nodes.add(node2);
	    nodes.add(node3);
	    nodes.add(node4);
	    nodes.add(node5);

	    Edge edge12 = new Edge(node1, node2);
	    Edge edge13 = new Edge(node1, node3);
	    Edge edge23 = new Edge(node2, node3);
	    Edge edge24 = new Edge(node2, node4);
	    Edge edge34 = new Edge(node3, node4);
	    Edge edge35 = new Edge(node3, node5);
	    Edge edge45 = new Edge(node4, node5);

	    LinkedList<Edge> edges = new LinkedList<Edge>();
	    edges.add(edge12);
	    edges.add(edge13);
	    edges.add(edge23);
	    edges.add(edge24);
	    edges.add(edge34);
	    edges.add(edge35);
	    edges.add(edge45);
	    
		Graph graph = new Graph(nodes, edges);
		graphs.add(graph);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}