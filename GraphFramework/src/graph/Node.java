package graph;
import java.awt.Color;
import java.util.ArrayList;

public class Node {
    private final String label;
    private final Color color;
    private final ArrayList<Node> adjacentNodes;
    private final ArrayList<Node> destinationNodes;

    public Node(String label, Color color) {
        this.label = label;
        this.color = color;
        
        this.adjacentNodes = new ArrayList<>();
        this.destinationNodes = new ArrayList<>();
    }
    
    public String getLabel() {
    	return this.label;
    }
    
    public Color getColor() {
    	return this.color;
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
