import java.util.ArrayList;
import java.util.LinkedList;

public abstract class GraphDecorator implements IGraph {
    protected IGraph decoratedGraph;
    int numberOfNodes;
  	LinkedList<Edge> edges;
    
    public GraphDecorator(IGraph decoratedGraph) {
        this.decoratedGraph = decoratedGraph;
        this.numberOfNodes = decoratedGraph.getNumberOfNodes();
        this.edges = decoratedGraph.getEdges();
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
	
	public int getNumberOfNodes() {
		return decoratedGraph.getNumberOfNodes();
	}
	
	public LinkedList<Edge> getEdges() {
		return decoratedGraph.getEdges();
	}
}
