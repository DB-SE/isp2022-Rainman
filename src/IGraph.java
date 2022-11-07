import java.util.ArrayList;
import java.util.LinkedList;

public interface IGraph {
	
	void depthFirstSearch(Node start);
    void minimumSpanningTree();
    void visit(Node node);
    void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited);
    int root(int[] parent, int v);
    boolean merge(int[] parent, int v,int u);
    void mstOutput(NumEdge i, ArrayList<Node> nodes);
	LinkedList<Edge> getEdges();
	int getNumberOfNodes();
}
