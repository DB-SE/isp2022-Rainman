public class Edge implements Comparable<Edge> {
    private final Node source;
    private final Node destination;
    private final int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        source.addAdjacentNode(destination);
        destination.addAdjacentNode(source);
    }

    @Override
    public int compareTo(Edge next) {
        return this.weight - next.weight;
    }
    
    public Node getSource() {
    	return this.source;
    }
    
    public Node getDestination() {
    	return this.destination;
    }
    public int getWeight() {return this.weight;}
}
