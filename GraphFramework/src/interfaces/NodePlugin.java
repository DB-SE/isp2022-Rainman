package interfaces;

import java.util.LinkedList;

import graph.Node;
import graph.NumEdge;

public interface NodePlugin {
	public void mstOutput(NumEdge i, LinkedList<Node> nodes);
	public void visit(Node node);
}
