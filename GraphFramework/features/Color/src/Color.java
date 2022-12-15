import java.util.LinkedList;

import graph.Node;
import graph.NumEdge;
import interfaces.NodePlugin;

public class Color implements NodePlugin {

	@Override
	public void mstOutput(NumEdge i, LinkedList<Node> nodes) {
		System.out.println("("+nodes.get(i.s).getColor()+","+nodes.get(i.d).getColor()+")");		
	}

	@Override
	public void visit(Node node) {
    	System.out.printf(" with Color: " + node.getColor());
	}

}
