package interfaces;

import java.util.ArrayList;
import graph.Node;
import graph.NumEdge;

public interface NodePlugin {
	public void print();
	public void mstOutput(NumEdge i, ArrayList<Node> nodes);
	public void visit(Node node);
}
