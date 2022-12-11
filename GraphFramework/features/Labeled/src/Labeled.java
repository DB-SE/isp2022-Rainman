import java.util.ArrayList;

import graph.Node;
import graph.NumEdge;
import interfaces.NodePlugin;

public class Labeled implements NodePlugin {

	@Override
	public void print() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mstOutput(NumEdge i, ArrayList<Node> nodes) {
		System.out.println("("+nodes.get(i.s).getLabel()+","+nodes.get(i.d).getLabel()+")");
	}

	@Override
	public void visit(Node node) {
    	System.out.printf("%s<", node.getLabel());
	}
}
