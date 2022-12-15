import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Node;
import interfaces.AlgorithmPlugin;
import interfaces.NodePlugin;

public class DFS implements AlgorithmPlugin {

	private LinkedList<Node> nodes;
	private LinkedList<Edge> edges;
	private List<NodePlugin> nodePlugins; 
	
	@Override
	public void execute(Graph graph) {
		nodes = graph.getNodes();
		edges = graph.getEdges();
		nodePlugins = graph.getNodePlugins();
		
		System.out.printf("\n\nDFS: \n");
		
		if (graph.isDirected()){
			directedDepthFirstSearch();
		} else {
			baseDepthFirstSearch();
		}
	}
	
	private void baseDepthFirstSearch() {
		//used to remember the nodes that have already been visited;
		//index in isVisited corresponds to node with the same index in nodes
		boolean[] isVisited = new boolean[nodes.size()];

		baseDfsRecursive(nodes.get(0), isVisited); 
	}

    private void baseDfsRecursive(Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
    	visit(node);

    	//recursive method call for all nodes that are adjacent to current node and haven't been visited
    	for (Node n : node.getAdjacentNodes()) {
    		if(!isVisited[nodes.indexOf(n)]) {
    			baseDfsRecursive(n, isVisited);
    		}
    	}
    }   

	private void directedDepthFirstSearch() {    	
    	//find all outgoing Edges
    	for (Edge e : edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
    	
    	//used to remember the nodes that have already been visited;
    	//index in isVisited corresponds to node with the same index in nodes
    	boolean[] isVisited = new boolean[nodes.size()];
    	
    	directedDfsRecursive(nodes.get(0), isVisited); 
	}

    private void directedDfsRecursive(Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
   		visit(node);
    	
   		//recursive method call for all nodes that are adjacent to current node and haven't been visited
   		for (Node n : node.getDestinationNodes()) {
   			if(!isVisited[nodes.indexOf(n)]){
   				directedDfsRecursive(n, isVisited);
   			}
   		}
    }
    
    private void visit(Node node) {
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
