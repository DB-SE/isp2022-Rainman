import java.util.LinkedList;

import graph.Node;
import graph.NumEdge;
import interfaces.NodePlugin;

public class Labeled implements NodePlugin {

	@Override
	public void mstOutput(NumEdge i, LinkedList<Node> nodes) {
		System.out.println("("+nodes.get(i.s).getLabel()+","+nodes.get(i.d).getLabel()+")");
	}

	@Override
	public void visit(Node node) {
    	System.out.printf(" with Label: " + node.getLabel());
	}
}
