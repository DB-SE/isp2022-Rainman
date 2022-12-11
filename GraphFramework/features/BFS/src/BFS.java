import graph.Graph;
import interfaces.AlgorithmPlugin;

public class BFS implements AlgorithmPlugin {

	@Override
	public void execute(Graph graph) {
		graph.breadthFirstSearch();
	}
}
