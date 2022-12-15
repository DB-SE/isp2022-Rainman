package graph;
import java.util.LinkedList;
import java.util.List;

import interfaces.NodePlugin;

public class Graph {
	
    private final LinkedList<Node> nodes;
    private final LinkedList<Edge> edges;
    private final List<NodePlugin> nodePlugins;

    private final boolean weighted;
    private final boolean directed;

    public Graph(
    		LinkedList<Node> nodes, 
    		LinkedList<Edge> edges, 
    		List<NodePlugin> nodePlugins,
    		boolean weighted, 
    		boolean directed
    		) {

    	this.nodes = nodes;
    	this.edges = edges;
    	this.nodePlugins = nodePlugins;

    	this.weighted = weighted;
    	this.directed = directed;
    }
    
    public LinkedList<Node> getNodes() {
    	return this.nodes;
    }
    
    public LinkedList<Edge> getEdges() {
    	return this.edges;
    }
    
    public List<NodePlugin> getNodePlugins() {
    	return this.nodePlugins;
    }
    
    public boolean isWeighted() {
    	return this.weighted;
    }
    
    public boolean isDirected() {
    	return this.directed;
    }
    
}
