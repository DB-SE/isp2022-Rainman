package interfaces;

import java.util.ArrayList;

import graph.Graph;
import graph.Node;

public interface EdgePlugin {
	public void setGraph(Graph graph);
	public void minimumSpanningTree();
	public void depthFirstSearch();
	public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited);
	public void breadthFirstSearch();
}
