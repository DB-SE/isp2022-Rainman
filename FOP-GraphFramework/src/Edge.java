public  class Edge implements Comparable<Edge> {
	private final Node source;

	private final Node destination;


	public Edge  (Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    
		 addAdjacentNodes(source, destination);
	 }


	public Node getSource() {
    	return this.source;
    }


	public Node getDestination() {
    	return this.destination;
    }


	 private void  print__wrappee__Edges  () {
    	System.out.printf("Edge between " + source + " and " + destination);
    }


	 private void  print__wrappee__Weighted  () {
		print__wrappee__Edges();
		System.out.print(" weighted with " + weight);
	}


	void print() {
		print__wrappee__Weighted();
		System.out.print(" directed from " + source);
	}

	private int weight;


	@Override
	public int compareTo(Edge next) {
		return this.weight - next.weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getWeight() {
		return this.weight;
	}


	private void addAdjacentNodes(Node a, Node b) {
		 a.addAdjacentNode(b);
	     b.addAdjacentNode(a);
	 }


}
