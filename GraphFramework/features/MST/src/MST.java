import graph.Graph;
import interfaces.AlgorithmPlugin;

public class MST implements AlgorithmPlugin {

	@Override
	public void execute(Graph graph) {
		graph.minimumSpanningTree();
	}
	
}
