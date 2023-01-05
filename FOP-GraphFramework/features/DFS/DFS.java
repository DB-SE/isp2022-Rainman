import java.util.LinkedList;

public class DFS {
	private static LinkedList<Node> nodes;
	
	public static void execute(Graph graph) {
		nodes = graph.getNodes();
		
		System.out.printf("\n\nDFS: \n");
		
		//used to remember the nodes that have already been visited;
		//index in isVisited corresponds to node with the same index in nodes
		boolean[] isVisited = new boolean[nodes.size()];
		
		dfsRecursive(nodes.get(0), isVisited);
	}

    private static void dfsRecursive(Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
    	visit(node);

    	//recursive method call for all nodes that are adjacent to current node and haven't been visited
    	for (Node n : node.getAdjacentNodes()) {
    		if(!isVisited[nodes.indexOf(n)]) {
    			dfsRecursive(n, isVisited);
    		}
    	}
    }
    
    private static void visit(Node node) {
    	System.out.printf(node + "<");
    } 
}