import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private static LinkedList<Node> nodes;
	private static LinkedList<Edge> edges;
	
	public static void execute(Graph graph) {
		nodes = graph.getNodes();
		edges = graph.getEdges();
		
    	System.out.printf("\n\nBFS: \n");
    	
    	for (Edge e : edges) {
    		e.getSource().addDestinationNode(e.getDestination());
    	}
		
    	boolean[] isVisited = new boolean[nodes.size()];
    	breadthFirstSearch(nodes.get(0), isVisited);
	}
	
	public static void breadthFirstSearch(Node start, boolean[] isVisited) {
    	Queue<Node> queue = new LinkedList<Node>();
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
        		}
        	}
    	} 
	}
}