import graph.Graph;
import interfaces.AlgorithmPlugin;

public class DFS implements AlgorithmPlugin {

	@Override
	public void execute(Graph graph) {
		graph.depthFirstSearch();
	}
	
}
