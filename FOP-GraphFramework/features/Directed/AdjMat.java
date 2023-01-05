import java.util.LinkedList;

public class AdjMat {
	public static void execute(Graph graph) {
		LinkedList<Node> nodes = graph.getNodes();
		LinkedList<Edge> edges = graph.getEdges();
		int numberOfNodes = nodes.size();
		
		System.out.printf("\n\nAJM: \n   ");
		
		Boolean[][] adjmat = new Boolean[numberOfNodes][numberOfNodes];

		for(int i = 0; i < numberOfNodes; i++) {
			for(int j = 0; j < numberOfNodes; j++) {
				adjmat[i][j] = false;
			}
		}

		for (Edge e : edges) {
			adjmat[nodes.indexOf(e.getSource())][nodes.indexOf(e.getDestination())] = true;
		}
		
		printAdjacencyMatrix(numberOfNodes, adjmat);
	}
	
	private static void printAdjacencyMatrix(int numberOfNodes, Boolean[][] adjmat) {
		for (int i = 0; i < numberOfNodes; i++) {
			System.out.printf(" " + (i + 1));
		}
		System.out.printf("\n");
		
		for(int i = 0; i < numberOfNodes; i++) {
			
			System.out.printf("\n" + (i + 1) + "  ");

			for(int j = 0; j < numberOfNodes; j++) {
				System.out.printf(" " + (adjmat[i][j] ? 1 : 0));
			}
		}
		
	}
}