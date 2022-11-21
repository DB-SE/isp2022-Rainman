import java.util.ArrayList;
import java.util.LinkedList;

public interface IGraph {
	
	// #ifdef MST
	void minimumSpanningTree();
    int root(int[] parent, int v);
    boolean merge(int[] parent, int v,int u);
    void mstOutput(NumEdge i, ArrayList<Node> nodes);
    // #endif
    
    // #ifdef DFS
	void depthFirstSearch(Node start);
    void visit(Node node);
    void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited);
    // #endif
    
    // #ifdef Adjacency_Matrix
    Boolean[][] getAdjacencyMatrix();
    // #endif
	
	ArrayList<Node> getNodes();
	LinkedList<Edge> getEdges();
	int getNumberOfNodes();
}
