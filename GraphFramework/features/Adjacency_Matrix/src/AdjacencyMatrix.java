import graph.Graph;
import interfaces.AlgorithmPlugin;

public class AdjacencyMatrix implements AlgorithmPlugin {

	@Override
	public void execute(Graph graph) {
		graph.getAdjacencyMatrix();
	}

}
