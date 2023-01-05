
public class Edge {
	
	 public Edge(Node source, Node destination) {
		 addAdjacentNodes(source, destination);
	 }
	 
	 private void addAdjacentNodes(Node a, Node b) {
		 a.addAdjacentNode(b);
	     b.addAdjacentNode(a);
	 }
}