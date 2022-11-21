import java.util.ArrayList;

public class DirectedGraph extends GraphDecorator {
    public DirectedGraph(IGraph decoratedGraph) {
        super(decoratedGraph);
    }

    // #ifdef MST
    @Override
    public void minimumSpanningTree() {
        System.out.println("A minimum spanning tree can only be calculated on undirected graphs.");
    }
    // #endif
    
    // #ifdef DFS
    @Override
	public void depthFirstSearch(Node start) {
    	ArrayList<Node> nodes = this.getNodes();
    	
    	//find all outgoing Edges
    	for (Edge e : edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
    	
    	//used to remember the nodes that have already been visited;
    	//index in isVisited corresponds to node with the same index in nodes
    	boolean[] isVisited = new boolean[numberOfNodes];
    	
    	dfsRecursive(nodes, start, isVisited);  	
    	
    }
    
	@Override
    public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
   		visit(node);
    	
   		//recursive method call for all nodes that are adjacent to current node and haven't been visited
   		for (Node n : node.getDestinationNodes()) {
   			if(!isVisited[nodes.indexOf(n)]){
   				dfsRecursive(nodes, n, isVisited);
   			}
   		}
    }
	// #endif
}
