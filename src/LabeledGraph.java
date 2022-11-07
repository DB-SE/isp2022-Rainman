import java.util.ArrayList;

public class LabeledGraph extends GraphDecorator{
	
    public LabeledGraph(IGraph decoratedGraph) {
        super(decoratedGraph);
    }
    
    @Override
    public void visit(Node node) {
    	System.out.printf("%s<", node.getLabel());
    }

	@Override
    public void mstOutput(NumEdge i, ArrayList<Node> nodes) {
    		  System.out.println("("+nodes.get(i.s).getLabel()+","+nodes.get(i.d).getLabel()+")");
    }
}
