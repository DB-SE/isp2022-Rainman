import java.util.ArrayList; import java.util.LinkedList; import java.awt.Color; public  class Main {
	ArrayList<Graph> graphs = new ArrayList<Graph>();


	 private void  run__wrappee__Graph  () {
	
		Node node1 = new Node();
	    Node node2 = new Node();
	    Node node3 = new Node();
	    Node node4 = new Node();
	    Node node5 = new Node();
	    
	    LinkedList<Node> nodes = new LinkedList<Node>();
	    nodes.add(node1);
	    nodes.add(node2);
	    nodes.add(node3);
	    nodes.add(node4);
	    nodes.add(node5);

	    Edge edge12 = new Edge(node1, node2);
	    Edge edge13 = new Edge(node1, node3);
	    Edge edge23 = new Edge(node2, node3);
	    Edge edge24 = new Edge(node2, node4);
	    Edge edge34 = new Edge(node3, node4);
	    Edge edge35 = new Edge(node3, node5);
	    Edge edge45 = new Edge(node4, node5);

	    LinkedList<Edge> edges = new LinkedList<Edge>();
	    edges.add(edge12);
	    edges.add(edge13);
	    edges.add(edge23);
	    edges.add(edge24);
	    edges.add(edge34);
	    edges.add(edge35);
	    edges.add(edge45);
	    
		Graph graph = new Graph(nodes, edges);
		graphs.add(graph);
	}


	 private void  run__wrappee__Color  () {
		run__wrappee__Graph();
		LinkedList<Node> nodes = graphs.get(0).getNodes();
		
		nodes.get(0).setColor(Color.BLACK);
		nodes.get(1).setColor(Color.CYAN);
		nodes.get(2).setColor(Color.MAGENTA);
		nodes.get(3).setColor(Color.ORANGE);
		nodes.get(4).setColor(Color.RED);
	}


	 private void  run__wrappee__Labeled  () {
		run__wrappee__Color();
		LinkedList<Node> nodes = graphs.get(0).getNodes();
		
		nodes.get(0).setLabel("a");
		nodes.get(1).setLabel("b");
		nodes.get(2).setLabel("c");
		nodes.get(3).setLabel("d");
		nodes.get(4).setLabel("e");
	}


	 private void  run__wrappee__Weighted  () {
		run__wrappee__Labeled();
		LinkedList<Edge> edges = graphs.get(0).getEdges();
		
		edges.get(0).setWeight(3);
		edges.get(1).setWeight(4);
		edges.get(2).setWeight(5);
		edges.get(3).setWeight(6);
		edges.get(4).setWeight(1);
		edges.get(5).setWeight(14);
		edges.get(6).setWeight(8);
	}


	 private void  run__wrappee__Adjacency_Matrix  () {
		run__wrappee__Weighted();
		AdjMat.execute(graphs.get(0));
	}


	 private void  run__wrappee__DFS  () {
		run__wrappee__Adjacency_Matrix();
		DFS.execute(graphs.get(0));
	}


	protected void run() {
		run__wrappee__DFS();
		BFS.execute(graphs.get(0));
	}


	public static void main(String[] args) {
		new Main().run();
	}


}
