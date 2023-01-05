import java.util.ArrayList;

public class Node {
	private ArrayList<Node> adjacentNodes = new ArrayList<Node>();
	
	public ArrayList<Node> getAdjacentNodes() {
    	return this.adjacentNodes;
    }
    
    public void addAdjacentNode(Node node) {
    	this.adjacentNodes.add(node);
    }
}