import java.util.LinkedList; public class Graph {
	private final LinkedList<Node> nodes;

	private final LinkedList<Edge> edges;


	public Graph(LinkedList<Node> nodes, LinkedList<Edge> edges) {
    	this.nodes = nodes;
    	this.edges = edges;
    }


	public LinkedList<Node> getNodes() {
    	return this.nodes;
    }


	public LinkedList<Edge> getEdges() {
    	return this.edges;
    }


}
