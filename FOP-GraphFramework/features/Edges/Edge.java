
public class Edge {
	private final Node source;
    private final Node destination;
    
    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }
    
    public Node getSource() {
    	return this.source;
    }
    
    public Node getDestination() {
    	return this.destination;
    }
    
    void print() {
    	System.out.printf("Edge between " + source + " and " + destination);
    }
}