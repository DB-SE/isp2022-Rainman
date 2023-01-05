import java.awt.Color; import java.util.ArrayList; public  class Node {
	public static int id_ = 0;

	private int id;


	public Node() {
    	this.id = id_;
    	id_++;
    }


	public int getId() {
    	return this.id;
    }


	void print  () {
		System.out.print(label);
	}


	public String toString  () {
		return this.label;
	}

	private Color color;


	public void setColor(Color color) {
		this.color = color;
	}


	public Color getColor() {
		return this.color;
	}

	private String label;


	public Node(String label) {
		this.label = label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getLabel() {
		return this.label;
	}

	private ArrayList<Node> adjacentNodes = new ArrayList<Node>();


	public ArrayList<Node> getAdjacentNodes() {
    	return this.adjacentNodes;
    }


	public void addAdjacentNode(Node node) {
    	this.adjacentNodes.add(node);
    }

	private ArrayList<Node> destinationNodes = new ArrayList<Node>();


	public void addDestinationNode(Node node) {
    	this.destinationNodes.add(node);
    }


	public ArrayList<Node> getDestinationNodes() {
    	return this.destinationNodes;
    }


}
