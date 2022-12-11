import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Node;
import interfaces.EdgePlugin;

public class Directed implements EdgePlugin {
	
	private Graph graph;
	
	@Override
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	@Override
	public void minimumSpanningTree() {
        System.out.println("A minimum spanning tree can only be calculated on undirected graphs.");		
	}

	@Override
	public void depthFirstSearch() {
		ArrayList<Node> nodes = graph.getNodes();
    	
    	//find all outgoing Edges
    	for (Edge e : graph.edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
    	
    	//used to remember the nodes that have already been visited;
    	//index in isVisited corresponds to node with the same index in nodes
    	boolean[] isVisited = new boolean[graph.numberOfNodes];
    	
    	graph.dfsRecursive(nodes, nodes.get(0), isVisited); 
	}

	@Override
    public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
   		graph.visit(node);
    	
   		//recursive method call for all nodes that are adjacent to current node and haven't been visited
   		for (Node n : node.getDestinationNodes()) {
   			if(!isVisited[nodes.indexOf(n)]){
   				dfsRecursive(nodes, n, isVisited);
   			}
   		}
    }
	
	@Override
	public void breadthFirstSearch() {
		graph.baseBreadthFirstSearch();
	}
}
