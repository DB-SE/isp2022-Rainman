import java.util.ArrayList;

public class Node {
	private ArrayList<Node> destinationNodes = new ArrayList<Node>();
	
	public void addDestinationNode(Node node) {
    	this.destinationNodes.add(node);
    }
    
    public ArrayList<Node> getDestinationNodes() {
    	return this.destinationNodes;
    }
}