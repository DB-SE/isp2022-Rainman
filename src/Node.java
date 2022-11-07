import java.util.ArrayList;

public class Node {
    private final String label;
    private final ArrayList<Node> adjacentNodes;
    private final ArrayList<Node> destinationNodes;

    public Node(String label) {
        this.label = label;
        this.adjacentNodes = new ArrayList<>();
        this.destinationNodes = new ArrayList<>();
    }
    
    public String getLabel() {
    	return this.label;
    }
    
    public ArrayList<Node> getAdjacentNodes() {
    	return this.adjacentNodes;
    }
    
    public void addAdjacentNode(Node node) {
    	this.adjacentNodes.add(node);
    } 
    
    public void addDestinationNode(Node node) {
    	this.destinationNodes.add(node);
    }
    
    public ArrayList<Node> getDestinationNodes() {
    	return this.destinationNodes;
    }
} 
