import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph.Edge;
import graph.Graph;
import graph.Node;
import interfaces.AlgorithmPlugin;
import interfaces.NodePlugin;

public class BFS implements AlgorithmPlugin {

	private LinkedList<Node> nodes;
	private LinkedList<Edge> edges;
	private List<NodePlugin> nodePlugins; 
	
	@Override
	public void execute(Graph graph) {
		nodes = graph.getNodes();
		edges = graph.getEdges();
		nodePlugins = graph.getNodePlugins();
		
    	System.out.printf("\n\nBFS: \n");
		
		if (graph.isDirected()){
			directedBreadthFirstSearch();
		} else {
			baseBreadthFirstSearch();
		}
	}
	
    public void baseBreadthFirstSearch() {
    	boolean[] isVisited = new boolean[nodes.size()];
		baseBreadthFirstSearch(nodes.get(0), isVisited); 
    }
    
	public void baseBreadthFirstSearch(Node start, boolean[] isVisited) {
    	Queue<Node> queue = new LinkedList<>();
    	boolean[] queued = new boolean[nodes.size()];
    	queue.add(start);
    	queued[nodes.indexOf(start)] = true;
    	while(!queue.isEmpty()) {
    		Node cur = queue.remove();
    		int current = nodes.indexOf(cur);
        	if(!isVisited[current]) {
    		isVisited[current] = true;
        	visit(cur);
        	for(Node i: cur.getAdjacentNodes()) {
        		if(!isVisited[nodes.indexOf(i)]&&!queued[nodes.indexOf(i)]) {
        			queue.add(i);
        			queued[nodes.indexOf(i)] = true;
        		}
        	}}
    		
    	}
	}
	
    public void directedBreadthFirstSearch() {
    	for (Edge e : edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
    	
    	boolean[] isVisited = new boolean[nodes.size()];
    	
    	directedBreadthFirstSearch(nodes.get(0), isVisited); 
    }
    
	public void directedBreadthFirstSearch(Node start, boolean[] isVisited) {
    	Queue<Node> queue = new LinkedList<>();
    	boolean[] queued = new boolean[nodes.size()];
    	queue.add(start);
    	queued[nodes.indexOf(start)] = true;
    	while(!queue.isEmpty()) {
    		Node cur = queue.remove();
    		int current = nodes.indexOf(cur);
        	if(!isVisited[current]) {
    		isVisited[current] = true;
        	visit(cur);
        	for(Node i: cur.getDestinationNodes()) {
        		if(!isVisited[nodes.indexOf(i)]&&!queued[nodes.indexOf(i)]) {
        			queue.add(i);
        			queued[nodes.indexOf(i)] = true;
        		}
        	}}
    		
    	} 
	}
	
    public void visit(Node node) {
    	if (nodePlugins.size() > 0) {
    		System.out.printf("Node: ");
    		for (NodePlugin nodePlugin: nodePlugins) {
    			nodePlugin.visit(node);
    		}
    		System.out.println(" > ");
    	} else {
        	System.out.printf(node + "<");
    	}
    }
}
