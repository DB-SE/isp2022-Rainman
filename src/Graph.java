import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;

public class Graph {
    private int numberOfNodes;
    private LinkedList<Edge> edges;

    public Graph(int numberOfNodes, LinkedList<Edge> edges) {
        this.numberOfNodes = numberOfNodes;
        this.edges = edges;
    }
    
    public LinkedList<Edge> getEdges() {
    	return this.edges;
    } 

    public void minimumSpanningTree() {
        Collections.sort(edges);

    }

    public void depthFirstSearch(Node start) {
    	ArrayList<Node> nodes = new ArrayList<Node>(numberOfNodes);
    	
    	for (Edge e : edges) {
    		if (!nodes.contains(e.getSource())) {
    			nodes.add(e.getSource());
    		}
    		if (!nodes.contains(e.getDestination())) {
    			nodes.add(e.getDestination());
    		}
    	}
    	
    	boolean[] isVisited = new boolean[numberOfNodes];
    	
    	dfsRecursive(nodes, start, isVisited);  	
    	
    }
    
    private void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	isVisited[current] = true;
   		visit(node);
    	
   		for (Node n : node.getAdjacentNodes()) {
   			if(!isVisited[nodes.indexOf(n)]) {
   				dfsRecursive(nodes, n, isVisited);
   			}
   		}
   			
   		
    } 
    
    private void visit(Node node) {
    	System.out.printf("%s<", node.getLabel());
    } 
}
