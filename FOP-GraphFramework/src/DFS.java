import java.util.LinkedList; public  class DFS {
	private static LinkedList<Node> nodes;


	public static void execute  (Graph graph) {
		nodes = graph.getNodes();
		edges = graph.getEdges();
		
		System.out.printf("\n\nDFS: \n");
		
		
    	for (Edge e : edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
    	
    	
    	
    	boolean[] isVisited = new boolean[nodes.size()];
		
		dfsRecursive(nodes.get(0), isVisited);
	}


	private static void dfsRecursive  (Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	
    	isVisited[current] = true;
   		visit(node);
    	
   		
   		for (Node n : node.getDestinationNodes()) {
   			if(!isVisited[nodes.indexOf(n)]){
   				dfsRecursive(n, isVisited);
   			}
   		}
    }


	private static void visit(Node node) {
    	System.out.printf(node + "<");
    }

	private static LinkedList<Edge> edges;


}
