import java.util.LinkedList;

public class Main {
	
	protected void run() {
		original();
		LinkedList<Edge> edges = graphs.get(0).getEdges();
		
		edges.get(0).setWeight(3);
		edges.get(1).setWeight(4);
		edges.get(2).setWeight(5);
		edges.get(3).setWeight(6);
		edges.get(4).setWeight(1);
		edges.get(5).setWeight(14);
		edges.get(6).setWeight(8);
	}
}