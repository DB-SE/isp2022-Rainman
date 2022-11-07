import java.util.ArrayList;

public abstract class GraphDecorator implements IGraph {
    protected IGraph decoratedGraph;
    
    public GraphDecorator(IGraph decoratedGraph) {
        this.decoratedGraph = decoratedGraph;
    }
    
    public void depthFirstSearch(Node start) {
        decoratedGraph.depthFirstSearch(start);
    }
    
    public void minimumSpanningTree() {
        decoratedGraph.minimumSpanningTree();
    }
    
    public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
    	decoratedGraph.dfsRecursive(nodes, node, isVisited);
    }
    
    public void visit(Node node) {
    	decoratedGraph.visit(node);
    }
    
    public int root(int[] parent, int v) {
    	return decoratedGraph.root(parent, v);
    }
    
    public boolean merge(int[] parent, int v,int u) {
    	return decoratedGraph.merge(parent, v, u);
    }

	public void mstOutput(NumEdge i, ArrayList<Node> nodes) {
		decoratedGraph.mstOutput(i, nodes);
		
	}
}
