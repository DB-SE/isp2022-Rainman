import java.util.ArrayList;

public class DirectedGraph extends GraphDecorator {
    public DirectedGraph(IGraph decoratedGraph) {
        super(decoratedGraph);
    }

    @Override
    public void minimumSpanningTree() {
        System.out.println("A minimum spanning tree can only be calculated on undirected graphs.");
    }
    
    @Override
	public void depthFirstSearch(Node start) {
    	ArrayList<Node> nodes = new ArrayList<Node>(numberOfNodes);

    	//find all nodes, since we only have a list of edges, and remember them in a List
    	for (Edge e : edges) {
    		if (!nodes.contains(e.getSource())) {
    			nodes.add(e.getSource());
    		}
    		if (!nodes.contains(e.getDestination())) {
    			nodes.add(e.getDestination());
    		}
    	}
    	
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
}
