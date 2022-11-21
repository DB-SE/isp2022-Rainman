import java.util.LinkedList;
import java.util.ArrayList;

class NumEdge
{
    int s;
    int d;
    int w;
    NumEdge(int s,int d,int w)
    {
        this.s=s;
        this.d=d;
        this.w=w;
    }
}

public class Graph implements IGraph {
	private final int numberOfNodes;
    private final LinkedList<Edge> edges;
    private ArrayList<Node> nodes;

    public Graph(int numberOfNodes, LinkedList<Edge> edges) {
        this.numberOfNodes = numberOfNodes;
        this.edges = edges;
        this.nodes = calcNodes();
    }

    // #ifdef MST
	@Override
    public void minimumSpanningTree() {
    	
    	//create int based list of edges using the enumeration
    	ArrayList<NumEdge> g_edges = new ArrayList<NumEdge>(edges.size());
    	for (Edge e: edges) {
    		g_edges.add(new NumEdge(nodes.indexOf(e.getSource()),nodes.indexOf(e.getDestination()),e.getWeight()));
    	}
    	NumEdge[] g = g_edges.toArray(new NumEdge[0]);
    	//component parent list
    	int parent[] = new int[numberOfNodes];
    	//index of smallest edge going out of a component
    	int Min[] = new int[numberOfNodes];
    	//initialize parents with identity (every vertex is a component)
    	for(int i=0;i<numberOfNodes;i++)
        {
            parent[i]=i; 
        }
    	
    	  int edges = g.length-1;
    	  
    	  int components = numberOfNodes;
    	  ArrayList<NumEdge> ans_MST= new ArrayList<NumEdge>();
    	  
    	  while(components>1)
    	  {
    	      // Initialize Min for each component as -1.
    	      for(int i=0;i<numberOfNodes;i++)
    	      {
    	          Min[i]=-1;
    	      }
    	      for(int i=0;i<=edges;i++)
    	      {
    	          // If both source and end are from same component we don't process them.
    	          if(root(parent,g[i].d)==root(parent,g[i].s))
    	          		continue;
    	         
    	          int r_s=root(parent,g[i].s);
    	          if(Min[r_s]==-1 || g[i].w < g[Min[r_s]].w)
					  Min[r_s]=i;
    	          
    	          int r_d=root(parent,g[i].d);
    	          if(Min[r_d]==-1 || g[i].w < g[Min[r_d]].w)
					  Min[r_d]=i;
    	          
    	      }
    	      //collect edges and merge components
    	      for(int i=0;i<numberOfNodes;i++)
    	      {
    	          if(Min[i]!=-1)
    	          {
    	              if(merge(parent,g[Min[i]].d,g[Min[i]].s))
    	              { 
    	            	  ans_MST.add(g[Min[i]]);
    	                  components--;
    	              }
    	          }
    	      }
    	  }
    	  System.out.println("Minimum Spanning Tree uses edges:");
    	  for (NumEdge i: ans_MST) {
    		  mstOutput(i, nodes);
    	  }
    	 
    }
	
	@Override
	public void mstOutput(NumEdge i, ArrayList<Node> nodes) {
		System.out.println("("+nodes.get(i.s)+","+nodes.get(i.d)+")");
	}
    //find "root"representative of a component
	@Override
    public int root(int[] parent, int v)
    {
        if(parent[v]==v)
			return v;

        return parent[v]=root(parent,parent[v]);
    }
    //merge components and by replacing one of their root representatives with the other 
    @Override
    public boolean merge(int[] parent, int v,int u)
    {
        v=root(parent,v);
        u=root(parent,u);
        if (v==u) return false;
        parent[v]=u;
        return true;
    }
    // #endif
    
    // #if DFS
	@Override
	public void depthFirstSearch(Node start) {
    	
    	//used to remember the nodes that have already been visited;
    	//index in isVisited corresponds to node with the same index in nodes
    	boolean[] isVisited = new boolean[numberOfNodes];
    	
    	dfsRecursive(nodes, start, isVisited);  	
    	
    }
    
	@Override
    public void dfsRecursive(ArrayList<Node> nodes, Node node, boolean[] isVisited) {
    	int current = nodes.indexOf(node);
    	//mark current node as visited
    	isVisited[current] = true;
   		visit(node);
    	
   		//recursive method call for all nodes that are adjacent to current node and haven't been visited
   		for (Node n : node.getAdjacentNodes()) {
   			if(!isVisited[nodes.indexOf(n)]) {
   				dfsRecursive(nodes, n, isVisited);
   			}
   		}
    } 
    
    @Override
    public void visit(Node node) {
    	System.out.printf(node + "<");
    }
    // #endif
    
    // #ifdef Adjacency_Matrix
    @Override
    public Boolean[][] getAdjacencyMatrix() {
    	Boolean[][] adjmat = new Boolean[numberOfNodes][numberOfNodes];
    	
    	for(int i = 0; i < numberOfNodes; i++) {
    		for(int j = 0; j < numberOfNodes; j++) {
    			adjmat[i][j] = false;
    		}
    	}
    	
    	for (Edge e : edges) {
    		adjmat[nodes.indexOf(e.getSource())][nodes.indexOf(e.getDestination())] = true;
		// #ifndef directed
    		adjmat[nodes.indexOf(e.getDestination())][nodes.indexOf(e.getSource())] = true;
		// #endif
    	}
    	return adjmat;
    }
    // #endif
    
    public int getNumberOfNodes() {
    	return this.numberOfNodes;
    }
    
    public LinkedList<Edge> getEdges() {
    	return this.edges;
    }
    
    public ArrayList<Node> calcNodes() {
    	ArrayList<Node> nodes = new ArrayList<>(numberOfNodes);
    	
    	for (Edge e : edges) {
    		if (!nodes.contains(e.getSource())) {
    	   		nodes.add(e.getSource());
    	  	}
    	  	if (!nodes.contains(e.getDestination())) {
    	  		nodes.add(e.getDestination());
    		}
    	}
    	return nodes;
    }
    
    public ArrayList<Node> getNodes() {
    	return this.nodes;
    }
    
}
